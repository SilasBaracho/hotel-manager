package br.com.baracho.hm.fixture.hotelAddress;

import br.com.baracho.hm.core.domain.model.entities.HotelAddressDomain;
import br.com.baracho.hm.core.domain.model.entities.HotelDomain;
import br.com.baracho.hm.fixture.hotel.FixtureHotelDomain;
import com.github.javafaker.Faker;
import joptsimple.internal.Strings;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.UUID;

public class FixtureHotelAddressDomain {
    private FixtureHotelDomain fixtureHotelDomain = new FixtureHotelDomain();
    Faker faker = new Faker(Locale.forLanguageTag("pr-br"));
    public HotelAddressDomain getFixtureHotelAddressDomain() {
        return HotelAddressDomain.builder()
            .id(UUID.fromString("38d6acff-99be-45fb-86d7-26d70c91e006"))
            .postalCode("Beach Class")
            .street("Av. Boa Viagem")
            .complement("152")
            .postalCode("52258963")
            .neighborhood("Boa Viagem")
            .complement(Strings.EMPTY)
            .uf("PE")
            .hotelDomain(fixtureHotelDomain.getFixtureHotelDomain())
            .build();
    }

    public HotelAddressDomain getRandomFixtureHotelAddressDomain() {
        return HotelAddressDomain.builder()
            .id(UUID.randomUUID())
            .postalCode(faker.company().name())
            .street(faker.address().streetName())
            .complement(faker.address().buildingNumber())
            .postalCode(faker.address().zipCode())
            .neighborhood(faker.address().streetName())
            .complement(Strings.EMPTY)
            .uf(faker.address().state())
            .hotelDomain(fixtureHotelDomain.getFixtureHotelDomain())
            .build();
    }
}
