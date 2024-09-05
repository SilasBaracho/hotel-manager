package br.com.baracho.hm.core.application.service.booking;

import br.com.baracho.hm.core.application.gateway.BookingCreatedPendingProcessingProducerGateway;
import br.com.baracho.hm.core.application.repository.booking.FindBookingByIdBookingRepository;
import br.com.baracho.hm.core.application.repository.booking.FindBookingByIdGuestRepository;
import br.com.baracho.hm.core.application.repository.booking.SaveBookingRepository;
import br.com.baracho.hm.core.application.repository.hotel.FindHotelByIdRepository;
import br.com.baracho.hm.core.application.repository.room.FindRoomByIdRepository;
import br.com.baracho.hm.core.domain.model.entities.BookingDomain;
import br.com.baracho.hm.infrastructure.config.exceptionHandler.BadRequestException;
import br.com.baracho.hm.infrastructure.config.exceptionHandler.NotFoundException;
import br.com.baracho.hm.infrastructure.config.kafka.avro.CreateBookingAvro;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class BookingServiceImpl implements BookingService {
    private final BookingCreatedPendingProcessingProducerGateway<CreateBookingAvro> bookingCreatedPendingProcessingGateway;
    private final FindBookingByIdBookingRepository findBookingByIdBookingRepository;
    private final FindBookingByIdGuestRepository findBookingByIdGuestRepository;
    private final FindHotelByIdRepository findHotelByIdRepository;
    private final FindRoomByIdRepository findRoomByIdRepository;
    private final SaveBookingRepository saveBookingRepository;

    public BookingServiceImpl(
        BookingCreatedPendingProcessingProducerGateway<CreateBookingAvro> bookingCreatedPendingProcessingGateway,
        FindBookingByIdBookingRepository findBookingByIdBookingRepository,
        FindBookingByIdGuestRepository findBookingByIdGuestRepository,
        FindHotelByIdRepository findHotelByIdRepository,
        FindRoomByIdRepository findRoomByIdRepository,
        SaveBookingRepository saveBookingRepository
    ) {
        this.bookingCreatedPendingProcessingGateway = bookingCreatedPendingProcessingGateway;
        this.findBookingByIdBookingRepository = findBookingByIdBookingRepository;
        this.findBookingByIdGuestRepository = findBookingByIdGuestRepository;
        this.findHotelByIdRepository = findHotelByIdRepository;
        this.findRoomByIdRepository = findRoomByIdRepository;
        this.saveBookingRepository = saveBookingRepository;
    }


    @Override
    public BookingDomain createBooking(
        UUID idRoom,
        UUID idHotel,
        UUID idGuest,
        String guestEmail,
        String guestPhone,
        LocalDate checkIn,
        LocalDate checkOut
    ) {
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
            .guestEmail(guestEmail)
            .guestPhone(guestPhone)
            .checkInDate(checkIn)
            .checkOutDate(checkOut)
            .build();

        var bookingSaved = saveBookingRepository.execute(booking);

        bookingCreatedPendingProcessingGateway.execute(bookingSaved);

        return bookingSaved;
    }

    @Override
    public BookingDomain processBooking(UUID idBooking) {
        var booking = findBookingByIdBookingRepository.execute(idBooking)
            .orElseThrow(() -> new NotFoundException("Booking not found"));

        booking.bookingConfirmed();

        return saveBookingRepository.execute(booking);
    }

    @Override
    public Optional<BookingDomain> findBookingByIdGuest(UUID idGuest) {
        return findBookingByIdGuestRepository.execute(idGuest);
    }
}
