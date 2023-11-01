package com.pedro.sandboxcassandra.domain;

import com.pedro.sandboxcassandra.domain.AddressInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointOfInterest {

    private String name;
    private String description;
    private AddressInfo address;
}
