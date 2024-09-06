package br.com.baracho.hm.fixture.hotel;

import br.com.baracho.hm.core.domain.model.entities.HotelDomain;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.UUID;

public class FixtureHotelDomain {
    Faker faker = new Faker(Locale.forLanguageTag("pr-br"));
    public HotelDomain getFixtureHotelDomain() {
        return HotelDomain.builder()
            .id(UUID.fromString("38d6acff-99be-45fb-86d7-26d70c91e006"))
            .name("Beach Class")
            .checkInTime(LocalTime.of(14,0, 0))
            .checkOutTime(LocalTime.of(12,0, 0))
            .build();
    }


    public HotelDomain getRandomFixtureHotelDomain() {
        return HotelDomain.builder()
            .id(UUID.randomUUID())
            .name(faker.company().name())
            .checkInTime(generateRandomLocalTime())
            .checkOutTime(generateRandomLocalTime())
            .build();
    }

    private LocalTime generateRandomLocalTime() {
        return faker.date().future(1, java.util.concurrent.TimeUnit.DAYS)
            .toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalTime();
    }
}
