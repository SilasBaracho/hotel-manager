package br.com.baracho.hm.infrastructure.resource.booking.repository;

import br.com.baracho.hm.core.application.repository.booking.FindBookingByIdGuestRepository;
import br.com.baracho.hm.core.domain.model.entities.BookingDomain;
import br.com.baracho.hm.data.mapper.BookingMapper;
import br.com.baracho.hm.data.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class FindBookingByIdGuestRepositoryImpl implements FindBookingByIdGuestRepository {
    @Autowired
    private BookingMapper bookingMapper;
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<BookingDomain> execute(UUID idGuest) {
        return bookingRepository.findByIdGuest(idGuest)
            .stream()
            .map(bookingMapper::toDomain)
            .collect(Collectors.toList());
    }
}
