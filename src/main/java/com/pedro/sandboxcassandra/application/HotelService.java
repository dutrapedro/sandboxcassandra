package com.pedro.sandboxcassandra.application;

import com.pedro.sandboxcassandra.api.HotelRequest;
import com.pedro.sandboxcassandra.domain.Hotel;
import com.pedro.sandboxcassandra.infrastructure.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository repository;

    public Mono<Void> saveHotel(HotelRequest request) {
        final var hotel = new Hotel.Builder(request.getName(), request.getPhone(), request.getEmail(),
                request.getAddress(), request.getRooms())
                .withPointsOfInterests(request.getPointOfInterests())
                .build();

        return repository.save(hotel);
    }
}
