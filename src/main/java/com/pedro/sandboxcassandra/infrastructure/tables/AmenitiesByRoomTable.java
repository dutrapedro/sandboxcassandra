package com.pedro.sandboxcassandra.infrastructure.tables;

import com.pedro.sandboxcassandra.domain.RoomAmenity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("amenities_by_room")
@Getter
@Setter
public class AmenitiesByRoomTable {

    @PrimaryKeyColumn(name = "hotel_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String hotelId;

    @PrimaryKeyColumn(name = "room_number", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private Short roomNumber;

    @PrimaryKeyColumn(name = "amenity_name", ordinal = 2)
    private String amenityName;

    private String description;

    public static AmenitiesByRoomTable createWith(final String hotelId, final RoomAmenity amenity) {
        final var amenitiesByRoom = new AmenitiesByRoomTable();
        amenitiesByRoom.setHotelId(hotelId);
        amenitiesByRoom.setRoomNumber(amenity.getRoomNumber());
        amenitiesByRoom.setAmenityName(amenity.getName());
        amenitiesByRoom.setDescription(amenity.getDescription());

        return amenitiesByRoom;
    }
}
