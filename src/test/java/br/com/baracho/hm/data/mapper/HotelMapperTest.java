package br.com.baracho.hm.data.mapper;

import br.com.baracho.hm.core.domain.model.entities.HotelDomain;
import br.com.baracho.hm.data.schema.HotelSchema;
import br.com.baracho.hm.fixture.hotel.FixtureHotelDomain;
import br.com.baracho.hm.fixture.hotel.FixtureHotelSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class HotelMapperTest {
    @InjectMocks
    private HotelMapper hotelMapper;
    private HotelDomain hotelDomain;
    private HotelSchema hotelSchema;

    @BeforeEach
    void setup() {
        FixtureHotelDomain fixtureHotelDomain = new FixtureHotelDomain();
        FixtureHotelSchema fixtureHotelSchema = new FixtureHotelSchema();
        hotelDomain = fixtureHotelDomain.getRandomFixtureHotelDomain();
        hotelSchema = fixtureHotelSchema.getFixtureHotelSchema(hotelDomain);
    }

    @Test
    void ShouldConvertSchemaToDomain() {
        var result = hotelMapper.toDomain(hotelSchema);

        assertEquals(
            result,
            hotelDomain
        );
    }

    @Test
    void ShouldConvertDomainToSchema() {
        var result = hotelMapper.toSchema(hotelDomain);

        assertEquals(
            result,
            hotelSchema
        );
    }
}