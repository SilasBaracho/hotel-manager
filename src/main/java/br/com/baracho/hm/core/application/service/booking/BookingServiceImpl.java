package br.com.baracho.hm.core.application.service.booking;

import br.com.baracho.hm.core.application.repository.booking.FindBookingByIdGuestRepository;
import br.com.baracho.hm.core.application.repository.booking.SaveBookingRepository;
import br.com.baracho.hm.core.application.repository.hotel.FindHotelByIdRepository;
import br.com.baracho.hm.core.application.repository.room.FindRoomByIdRepository;
import br.com.baracho.hm.core.application.repository.room.SaveRoomRepository;
import br.com.baracho.hm.core.domain.model.entities.BookingDomain;
import br.com.baracho.hm.infrastructure.config.exceptionHandler.BadRequestException;
import br.com.baracho.hm.infrastructure.config.exceptionHandler.NotFoundException;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class BookingServiceImpl implements BookingService {
    private final FindBookingByIdGuestRepository findBookingByIdGuestRepository;
    private final FindHotelByIdRepository findHotelByIdRepository;
    private final FindRoomByIdRepository findRoomByIdRepository;
    private final SaveBookingRepository saveBookingRepository;

    public BookingServiceImpl(
        FindBookingByIdGuestRepository findBookingByIdGuestRepository,
        FindHotelByIdRepository findHotelByIdRepository,
        FindRoomByIdRepository findRoomByIdRepository,
        SaveBookingRepository saveBookingRepository
    ) {
        this.findBookingByIdGuestRepository = findBookingByIdGuestRepository;
        this.findHotelByIdRepository = findHotelByIdRepository;
        this.findRoomByIdRepository = findRoomByIdRepository;
        this.saveBookingRepository = saveBookingRepository;
    }


    @Override
    public BookingDomain createBooking(UUID idRoom, UUID idHotel, UUID idGuest, LocalDate checkIn, LocalDate checkOut) {
        var hotel = findHotelByIdRepository.execute(idHotel)
            .orElseThrow(() -> new NotFoundException("Hotel not found"));

        var room = findRoomByIdRepository.execute(idRoom)
            .map(it -> {
                if (!it.getHotelDomain().getId().equals(hotel.getId())) {
                    throw new BadRequestException("The room does not belong to the hotel indicated.");
                }
                return it;
            })
            .orElseThrow(() -> new NotFoundException("Room not found"));

        var booking = BookingDomain.builder()
            .hotelDomain(hotel)
            .roomDomain(room)
            .idGuest(idGuest)
            .checkInDate(checkIn)
            .checkOutDate(checkOut)
            .build();

        var bookingSaved = saveBookingRepository.execute(booking);

        return bookingSaved;
    }

    @Override
    public Optional<BookingDomain> findBookingByIdGuest(UUID idGuest) {
        return findBookingByIdGuestRepository.execute(idGuest);
    }
}
