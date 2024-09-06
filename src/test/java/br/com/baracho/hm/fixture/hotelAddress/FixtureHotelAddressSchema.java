package br.com.baracho.hm.fixture.hotelAddress;

import br.com.baracho.hm.core.domain.model.entities.HotelAddressDomain;
import br.com.baracho.hm.core.domain.model.entities.HotelDomain;
import br.com.baracho.hm.data.mapper.HotelAddressMapper;
import br.com.baracho.hm.data.mapper.HotelMapper;
import br.com.baracho.hm.data.schema.HotelAddressSchema;

public class FixtureHotelAddressSchema {
    private final HotelAddressMapper hotelAddressMapper = new HotelAddressMapper();

    public HotelAddressSchema getFixtureHotelAddressSchema(HotelAddressDomain hotelAddressDomain) {
        return hotelAddressMapper.toSchema(hotelAddressDomain);
    }
}
