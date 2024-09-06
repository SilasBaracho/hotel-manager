package br.com.baracho.hm.fixture.room;

import br.com.baracho.hm.core.domain.model.entities.HotelDomain;
import br.com.baracho.hm.core.domain.model.entities.RoomDomain;
import br.com.baracho.hm.core.domain.model.enums.RoomTypeEnum;
import br.com.baracho.hm.fixture.hotel.FixtureHotelDomain;
import com.github.javafaker.Faker;
import joptsimple.internal.Strings;
import scala.Int;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;

public class FixtureRoomDomain {
    private FixtureHotelDomain fixtureHotelDomain = new FixtureHotelDomain();
    Faker faker = new Faker(Locale.forLanguageTag("pr-br"));
    public RoomDomain getFixtureRoomDomain() {
        return RoomDomain.builder()
            .id(UUID.fromString("38d6acff-99be-45fb-86d7-26d70c91e006"))
            .pricePerNight(new BigDecimal(100))
            .roomType(RoomTypeEnum.SINGLE_ROOM)
            .numberGuests(1)
            .roomNumber(112)
            .floor(2)
            .hotelDomain(fixtureHotelDomain.getFixtureHotelDomain())
            .build();
    }

    public RoomDomain getRandomFixtureRoomDomain() {
        return RoomDomain.builder()
            .id(UUID.randomUUID())
            .pricePerNight(new BigDecimal(faker.numerify("100")))
            .roomType(RoomTypeEnum.SINGLE_ROOM)
            .numberGuests(Integer.valueOf(faker.numerify("1")))
            .roomNumber(Integer.valueOf(faker.numerify("3")))
            .floor(Integer.valueOf(faker.numerify("1")))
            .hotelDomain(fixtureHotelDomain.getFixtureHotelDomain())
            .build();
    }
}
