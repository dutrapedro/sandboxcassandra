package com.pedro.sandboxcassandra.api;

import com.pedro.sandboxcassandra.application.HotelService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("hotel")
@RequiredArgsConstructor
@Slf4j
public class HotelController {

    private final HotelService service;

    @GetMapping
    public Mono<ResponseEntity<HotelResponse>> getHotels() {
        return Mono.just(ResponseEntity.ok(new HotelResponse()));
    }

    @PostMapping
    public Mono<Void> saveHotel(@RequestBody @NotNull HotelRequest request) {
        log.info("Received {}", request.getName());
        return service.saveHotel(request);
    }
}
