package br.com.baracho.hm.data.mapper;

import br.com.baracho.hm.core.domain.model.hotel.entities.HotelAddressDomain;
import br.com.baracho.hm.data.schema.HotelAddressSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HotelAddressMapper implements Mapper<HotelAddressDomain, HotelAddressSchema> {
    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public HotelAddressDomain toDomain(HotelAddressSchema hotelAddressSchema) {
        return HotelAddressDomain.builder()
            .id(hotelAddressSchema.getId())
            .postalCode(hotelAddressSchema.getPostalCode())
            .street(hotelAddressSchema.getStreet())
            .complement(hotelAddressSchema.getComplement())
            .neighborhood(hotelAddressSchema.getNeighborhood())
            .locale(hotelAddressSchema.getLocale())
            .uf(hotelAddressSchema.getUf())
            .hotelDomain(hotelMapper.toDomain(hotelAddressSchema.getHotelSchema()))
            .build();
    }

    @Override
    public HotelAddressSchema toSchema(HotelAddressDomain hotelAddressDomain) {
        return HotelAddressSchema.builder()
            .id(hotelAddressDomain.getId())
            .postalCode(hotelAddressDomain.getPostalCode())
            .street(hotelAddressDomain.getStreet())
            .complement(hotelAddressDomain.getComplement())
            .neighborhood(hotelAddressDomain.getNeighborhood())
            .locale(hotelAddressDomain.getLocale())
            .uf(hotelAddressDomain.getUf())
            .hotelSchema(hotelMapper.toSchema(hotelAddressDomain.getHotelDomain()))
            .build();
    }
}
