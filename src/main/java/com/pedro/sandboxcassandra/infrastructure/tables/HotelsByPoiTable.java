package com.pedro.sandboxcassandra.infrastructure.tables;

import com.pedro.sandboxcassandra.domain.AddressInfo;
import com.pedro.sandboxcassandra.domain.Hotel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("hotels_by_poi")
@Getter
@Setter
public class HotelsByPoiTable {

    @PrimaryKeyColumn(name = "poi_name", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String poiName;

    @PrimaryKeyColumn(name = "hotel_id", ordinal = 1)
    private String hotelId;
    private String name;
    private String phone;
    private AddressInfo address;

    public static HotelsByPoiTable createWith(final String poiName, final Hotel hotel) {
        final var hotelsByPoi = new HotelsByPoiTable();
        hotelsByPoi.setPoiName(poiName);
        hotelsByPoi.setHotelId(hotel.getId());
        hotelsByPoi.setName(hotel.getName());
        hotelsByPoi.setPhone(hotel.getPhone());
        hotelsByPoi.setAddress(hotel.getAddress());

        return hotelsByPoi;
    }
}
