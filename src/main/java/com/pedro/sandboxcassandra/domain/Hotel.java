package com.pedro.sandboxcassandra.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
public class Hotel {

    private String id;
    private String name;
    private String phone;
    private String email;
    private AddressInfo address;
    private List<Room> rooms;
    private List<PointOfInterest> pointOfInterests;

    private Hotel() {
    }

    private Hotel(final String name, final String phone, final String email, final AddressInfo address,
                  final List<Room> rooms, final List<PointOfInterest> pointOfInterests) {

        this.name = Optional.ofNullable(name).orElseThrow(() -> new IllegalArgumentException("Name is required!"));
        this.phone = Optional.ofNullable(phone).orElseThrow(() -> new IllegalArgumentException("Phone is required!"));
        this.email = Optional.ofNullable(email).orElseThrow(() -> new IllegalArgumentException("Email is required!"));
        this.address = address;
        this.rooms = rooms;
        this.pointOfInterests = pointOfInterests;
        this.id = this.name.substring(0, 3) + "_" + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        this.rooms.forEach(room -> room.setHotelId(this.id));
    }

    public static class Builder {
        private final String name;
        private final String phone;
        private final String email;
        private final AddressInfo address;
        private final List<Room> rooms;
        private List<PointOfInterest> pointOfInterests;
        public Builder(final String name, final String phone, final String email, final AddressInfo address,
                       final List<Room> rooms) {
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.address = address;
            this.rooms = rooms;
        }

        public Builder withPointsOfInterests(List<PointOfInterest> pointOfInterests) {
            this.pointOfInterests = pointOfInterests;

            return this;
        }

        public Hotel build() {
            return new Hotel(this.name, this.phone, this.email, this.address, this.rooms, this.pointOfInterests);
        }
    }
}
