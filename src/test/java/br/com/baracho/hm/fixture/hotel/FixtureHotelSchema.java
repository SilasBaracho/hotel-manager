package br.com.baracho.hm.fixture.hotel;

import br.com.baracho.hm.core.domain.model.entities.HotelDomain;
import br.com.baracho.hm.data.mapper.HotelMapper;
import br.com.baracho.hm.data.schema.HotelSchema;
import com.github.javafaker.Faker;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.UUID;

public class FixtureHotelSchema {
    private final HotelMapper hotelMapper = new HotelMapper();

    public HotelSchema getFixtureHotelSchema(HotelDomain hotelDomain) {
        return hotelMapper.toSchema(hotelDomain);
    }
}
