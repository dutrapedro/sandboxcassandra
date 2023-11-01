package com.pedro.sandboxcassandra.domain;

import com.pedro.sandboxcassandra.domain.Room;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomAmenity {

    private Short roomNumber;

    @NotNull
    private String name;

    @NotNull
    private String description;
}
