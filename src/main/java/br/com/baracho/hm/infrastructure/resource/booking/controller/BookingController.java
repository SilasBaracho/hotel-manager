package br.com.baracho.hm.infrastructure.resource.booking.controller;

import br.com.baracho.hm.core.application.service.booking.BookingService;
import br.com.baracho.hm.core.domain.model.entities.BookingDomain;
import br.com.baracho.hm.infrastructure.resource.booking.controller.dto.BookingInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/{id_guest}")
    public Optional<BookingDomain> findHotelByLocale(
        @PathVariable("id_guest") UUID idGuest
    ) {
        return bookingService.findBookingByIdGuest(idGuest);
    }

    @PostMapping
    public void createBooking(@RequestBody BookingInput input) {
        var booking = bookingService.createBooking(
            input.getIdRoom(), input.getIdHotel(), input.getIdGuest(), input.getCheckIn(), input.getCheckOut()
        );

        //return new BookingDomain();
    }
}
