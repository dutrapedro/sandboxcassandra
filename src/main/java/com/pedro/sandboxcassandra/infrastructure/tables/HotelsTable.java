package com.pedro.sandboxcassandra.infrastructure.tables;

import com.pedro.sandboxcassandra.domain.AddressInfo;
import com.pedro.sandboxcassandra.domain.Hotel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("hotels")
@Getter
@Setter
public class HotelsTable {

    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED, ordinal = 0)
    private String hotelId;

    private String name;

    private String phone;

    private AddressInfo address;

    public static HotelsTable createWithHotel(Hotel hotel) {
        final var hotelsTable = new HotelsTable();
        hotelsTable.hotelId = hotel.getId();
        hotelsTable.setName(hotel.getName());
        hotelsTable.setPhone(hotel.getPhone());
        hotelsTable.setAddress(hotel.getAddress());

        return hotelsTable;
    }
}
