package br.com.baracho.hm.infrastructure.resource.booking.repository;

import br.com.baracho.hm.core.application.repository.booking.FindBookingByIdBookingRepository;
import br.com.baracho.hm.core.application.repository.booking.FindBookingByIdGuestRepository;
import br.com.baracho.hm.core.domain.model.entities.BookingDomain;
import br.com.baracho.hm.data.mapper.BookingMapper;
import br.com.baracho.hm.data.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class FindBookingByIdBookingRepositoryImpl implements FindBookingByIdBookingRepository {
    @Autowired
    private BookingMapper bookingMapper;
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Optional<BookingDomain> execute(UUID idBooking) {
        return bookingRepository.findById(idBooking).map(bookingMapper::toDomain);
    }
}
