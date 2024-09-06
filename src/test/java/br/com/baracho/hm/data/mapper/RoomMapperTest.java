package br.com.baracho.hm.data.mapper;

import br.com.baracho.hm.core.domain.model.entities.RoomDomain;
import br.com.baracho.hm.data.schema.RoomSchema;
import br.com.baracho.hm.fixture.hotelAddress.FixtureHotelAddressDomain;
import br.com.baracho.hm.fixture.hotelAddress.FixtureHotelAddressSchema;
import br.com.baracho.hm.fixture.room.FixtureRoomDomain;
import br.com.baracho.hm.fixture.room.FixtureRoomSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RoomMapperTest {
    @InjectMocks
    private RoomMapper RoomMapper;
    @Mock
    private HotelMapper hotelMapper;
    private RoomDomain roomDomain;
    private RoomSchema roomSchema;

    @BeforeEach
    void setup() {
        FixtureRoomDomain fixtureRoomDomain = new FixtureRoomDomain();
        FixtureRoomSchema fixtureRoomSchema = new FixtureRoomSchema();
        roomDomain = fixtureRoomDomain.getRandomFixtureRoomDomain();
        roomSchema = fixtureRoomSchema.getFixtureRoomSchema(roomDomain);
    }

    @Test
    void ShouldConvertSchemaToDomain() {
        var result = RoomMapper.toDomain(roomSchema);

        assertEquals(
            result,
            roomDomain
        );
    }

    @Test
    void ShouldConvertDomainToSchema() {
        var result = RoomMapper.toSchema(roomDomain);

        assertEquals(
            result,
            roomSchema
        );
    }
}