package br.com.baracho.hm.infrastructure.resource.booking.repository;

import br.com.baracho.hm.core.application.repository.booking.SaveBookingRepository;
import br.com.baracho.hm.core.domain.model.entities.BookingDomain;
import br.com.baracho.hm.data.mapper.BookingMapper;
import br.com.baracho.hm.data.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveBookingRepositoryImpl implements SaveBookingRepository {
    @Autowired
    private BookingMapper bookingMapper;
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public BookingDomain execute(BookingDomain bookingDomain) {
        var bookingSaved = bookingRepository.save(bookingMapper.toSchema(bookingDomain));
        return bookingMapper.toDomain(bookingSaved);
    }
}
