package br.com.baracho.hm.core.application.service.booking;

import br.com.baracho.hm.core.domain.model.entities.BookingDomain;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface BookingService {
    BookingDomain createBooking(UUID idRoom, UUID idHotel, UUID idGuest, LocalDate checkIn, LocalDate checkOut);

    Optional<BookingDomain> findBookingByIdGuest(UUID idGuest);
}
