package br.com.baracho.hm.data.mapper;

import br.com.baracho.hm.core.domain.model.entities.HotelAddressDomain;
import br.com.baracho.hm.data.schema.HotelAddressSchema;
import br.com.baracho.hm.fixture.hotelAddress.FixtureHotelAddressDomain;
import br.com.baracho.hm.fixture.hotelAddress.FixtureHotelAddressSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class HotelAddressMapperTest {
    @InjectMocks
    private HotelAddressMapper hotelAddressMapper;
    @Mock
    private HotelMapper hotelMapper;
    private HotelAddressDomain hotelAddressDomain;
    private HotelAddressSchema hotelAddressSchema;

    @BeforeEach
    void setup() {
        FixtureHotelAddressDomain fixtureHotelAddressDomain = new FixtureHotelAddressDomain();
        FixtureHotelAddressSchema fixtureHotelAddressSchema = new FixtureHotelAddressSchema();
        hotelAddressDomain = fixtureHotelAddressDomain.getRandomFixtureHotelAddressDomain();
        hotelAddressSchema = fixtureHotelAddressSchema.getFixtureHotelAddressSchema(hotelAddressDomain);
    }

    @Test
    void ShouldConvertSchemaToDomain() {
        var result = hotelAddressMapper.toDomain(hotelAddressSchema);

        assertEquals(
            result,
            hotelAddressDomain
        );
    }

    @Test
    void ShouldConvertDomainToSchema() {
        var result = hotelAddressMapper.toSchema(hotelAddressDomain);

        assertEquals(
            result,
            hotelAddressSchema
        );
    }
}