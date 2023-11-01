package com.pedro.sandboxcassandra.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Getter
@Setter
@UserDefinedType("address")
public class AddressInfo {

    @NotNull
    private String street;

    @NotNull
    @Column("state_or_province")
    private String state;

    @NotNull
    private String city;

    @NotNull
    private String country;

    @NotNull
    @Column("postal_code")
    private String postalCode;
}
