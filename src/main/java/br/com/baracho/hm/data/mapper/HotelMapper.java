package br.com.baracho.hm.data.mapper;

import br.com.baracho.hm.core.domain.model.entities.HotelDomain;
import br.com.baracho.hm.data.schema.HotelSchema;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper implements Mapper<HotelDomain, HotelSchema> {
    @Override
    public HotelDomain toDomain(HotelSchema hotelSchema) {
        return HotelDomain.builder()
            .id(hotelSchema.getId())
            .name(hotelSchema.getName())
            .checkInTime(hotelSchema.getCheckInTime())
            .checkOutTime(hotelSchema.getCheckOutTime())
            .createdAt(hotelSchema.getCreatedAt())
            .updatedAt(hotelSchema.getUpdatedAt())
            .build();
    }

    @Override
    public HotelSchema toSchema(HotelDomain hotelDomain) {
        return HotelSchema.builder()
            .id(hotelDomain.getId())
            .name(hotelDomain.getName())
            .checkInTime(hotelDomain.getCheckInTime())
            .checkOutTime(hotelDomain.getCheckOutTime())
            .createdAt(hotelDomain.getCreatedAt())
            .updatedAt(hotelDomain.getUpdatedAt())
            .build();
    }
}
