package com.pedro.sandboxcassandra.infrastructure.tables;

import com.pedro.sandboxcassandra.domain.Room;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;

@Table("available_rooms_by_hotel_date")
@Getter
@Setter
public class AvailableRoomsByHotelDateTable {

    @PrimaryKeyColumn(name = "hotel_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String hotelId;

    @PrimaryKeyColumn(name = "date", ordinal = 1)
    private LocalDate date;

    @PrimaryKeyColumn(name = "room_number", ordinal = 2)
    private Short roomNumber;

    @Column("is_available")
    private boolean isAvailable;


    // TODO: Make room decide if it is available or not
    public static AvailableRoomsByHotelDateTable createWith(final Room room) {
        final var availableRoomsByHotel = new AvailableRoomsByHotelDateTable();
        availableRoomsByHotel.setHotelId(room.getHotelId());
        availableRoomsByHotel.setDate(LocalDate.now());
        availableRoomsByHotel.setRoomNumber(room.getNumber());
        availableRoomsByHotel.setAvailable(true);

        return availableRoomsByHotel;

    }
}
