package br.com.baracho.hm.core.application.repository.booking;

import br.com.baracho.hm.core.domain.model.entities.BookingDomain;

public interface SaveBookingRepository {
    BookingDomain execute(BookingDomain bookingDomain);
}
