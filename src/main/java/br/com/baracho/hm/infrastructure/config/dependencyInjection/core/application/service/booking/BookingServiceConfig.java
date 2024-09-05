package br.com.baracho.hm.infrastructure.config.dependencyInjection.core.application.service.booking;

import br.com.baracho.hm.core.application.gateway.BookingCreatedPendingProcessingGateway;
import br.com.baracho.hm.core.application.repository.booking.FindBookingByIdGuestRepository;
import br.com.baracho.hm.core.application.repository.booking.SaveBookingRepository;
import br.com.baracho.hm.core.application.repository.hotel.FindHotelByIdRepository;
import br.com.baracho.hm.core.application.repository.hotel.FindHotelsByLocaleRepository;
import br.com.baracho.hm.core.application.repository.room.FindRoomByIdRepository;
import br.com.baracho.hm.core.application.repository.room.SaveRoomRepository;
import br.com.baracho.hm.core.application.service.booking.BookingServiceImpl;
import br.com.baracho.hm.core.application.service.hotel.HotelServiceImpl;
import br.com.baracho.hm.core.domain.model.entities.BookingDomain;
import br.com.baracho.hm.infrastructure.config.kafka.avro.CreateBookingAvro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookingServiceConfig {
    @Bean
    public BookingServiceImpl bookingService(
        BookingCreatedPendingProcessingGateway<CreateBookingAvro> bookingCreatedPendingProcessingGateway,
        FindBookingByIdGuestRepository findBookingByIdGuestRepository,
        FindHotelByIdRepository findHotelByIdRepository,
        FindRoomByIdRepository findRoomByIdRepository,
        SaveBookingRepository saveBookingRepository
    ) {
        return new BookingServiceImpl(
            bookingCreatedPendingProcessingGateway,
            findBookingByIdGuestRepository,
            findHotelByIdRepository,
            findRoomByIdRepository,
            saveBookingRepository
        );
    }
}
