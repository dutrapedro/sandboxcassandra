package com.pedro.sandboxcassandra.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Room {

    private String hotelId;

    @NotNull
    private Short number;

    private BookingDate bookingDate;

    @NotEmpty
    private List<RoomAmenity> amenities;
}
