package com.pedro.sandboxcassandra.infrastructure.repository;


import com.pedro.sandboxcassandra.domain.Hotel;
import reactor.core.publisher.Mono;

public interface HotelRepository {

    Mono<Void> save(Hotel hotel);
}
