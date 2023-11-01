package com.pedro.sandboxcassandra.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookingDate {

    @NotNull
    private LocalDateTime startTime;

    @NotEmpty
    private LocalDateTime endTime;
}
