package com.pedro.sandboxcassandra.infrastructure.repository;

import com.pedro.sandboxcassandra.domain.Hotel;
import com.pedro.sandboxcassandra.domain.PointOfInterest;
import com.pedro.sandboxcassandra.domain.Room;
import com.pedro.sandboxcassandra.domain.RoomAmenity;
import com.pedro.sandboxcassandra.infrastructure.tables.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.core.ReactiveCassandraTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class HotelRepositoryImpl implements HotelRepository {

    private final ReactiveCassandraTemplate template;

    @Override
    public Mono<Void> save(Hotel hotel) {
        return Mono.when(saveHotels(hotel), saveHotelByPoi(hotel), saveAvailableRoomsByDate(hotel.getRooms()))
                .then();
    }

    private Mono<HotelsTable> saveHotels(Hotel hotel) {
        return template.insert(HotelsTable.createWithHotel(hotel));
    }

    private Mono<Void> saveHotelByPoi(Hotel hotel) {
        return Flux.fromIterable(hotel.getPointOfInterests())
                .flatMap(pointOfInterest -> template.insert(HotelsByPoiTable.createWith(pointOfInterest.getName(), hotel)).thenReturn(pointOfInterest))
                .flatMap(pointOfInterest -> savePoisByHotel(hotel.getId(), pointOfInterest))
                .then();
    }

    private Mono<PoisByHotelTable> savePoisByHotel(String hotelId, PointOfInterest pointOfInterest) {
        return template.insert(PoisByHotelTable.createWith(hotelId, pointOfInterest));
    }

    private Mono<Void> saveAvailableRoomsByDate(List<Room> rooms) {
        return Flux.fromIterable(rooms)
                .flatMap(room -> template.insert(AvailableRoomsByHotelDateTable.createWith(room)).thenReturn(room))
                .flatMap(room -> saveAmenitiesByRoom(room.getHotelId(), room.getAmenities()))
                .then();

    }

    private Flux<AmenitiesByRoomTable> saveAmenitiesByRoom(String hotelId, List<RoomAmenity> amenities) {
        return Flux.fromIterable(amenities)
                .flatMap(amenity -> template.insert(AmenitiesByRoomTable.createWith(hotelId, amenity)));
    }

}
