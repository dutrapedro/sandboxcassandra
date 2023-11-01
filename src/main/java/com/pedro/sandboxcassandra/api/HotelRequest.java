package com.pedro.sandboxcassandra.api;

import com.pedro.sandboxcassandra.domain.AddressInfo;
import com.pedro.sandboxcassandra.domain.PointOfInterest;
import com.pedro.sandboxcassandra.domain.Room;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HotelRequest {

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String phone;

    @NotNull
    private AddressInfo address;

    @NotEmpty
    private List<Room> rooms;

    private List<PointOfInterest> pointOfInterests;
}
