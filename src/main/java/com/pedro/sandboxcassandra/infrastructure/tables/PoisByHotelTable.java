package com.pedro.sandboxcassandra.infrastructure.tables;

import com.pedro.sandboxcassandra.domain.PointOfInterest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("pois_by_hotel")
@Getter
@Setter
public class PoisByHotelTable {

    @PrimaryKeyColumn(name = "hotel_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String hotelId;

    @PrimaryKeyColumn(name = "poi_name", ordinal = 1)
    private String poiName;

    private String description;

    public static PoisByHotelTable createWith(final String hotelId, final PointOfInterest pointOfInterest) {
        final var poisByHotel = new PoisByHotelTable();
        poisByHotel.setHotelId(hotelId);
        poisByHotel.setPoiName(pointOfInterest.getName());
        poisByHotel.setDescription(pointOfInterest.getDescription());

        return poisByHotel;
    }

}
