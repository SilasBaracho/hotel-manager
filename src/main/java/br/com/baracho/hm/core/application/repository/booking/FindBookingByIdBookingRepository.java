package br.com.baracho.hm.core.application.repository.booking;

import br.com.baracho.hm.core.domain.model.entities.BookingDomain;

import java.util.Optional;
import java.util.UUID;

public interface FindBookingByIdBookingRepository {
    Optional<BookingDomain> execute(UUID idBooking);
}
