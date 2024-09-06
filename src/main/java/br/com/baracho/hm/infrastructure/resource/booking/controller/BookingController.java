package br.com.baracho.hm.infrastructure.resource.booking.controller;

import br.com.baracho.hm.core.application.service.booking.BookingService;
import br.com.baracho.hm.core.domain.model.entities.BookingDomain;
import br.com.baracho.hm.infrastructure.resource.booking.controller.dto.BookingInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/{id_guest}")
    public ResponseEntity<List<BookingDomain>> findHotelByLocale(
        @PathVariable("id_guest") UUID idGuest
    ) {
        return new ResponseEntity<>(bookingService.findBookingByIdGuest(idGuest), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookingDomain> createBooking(@RequestBody BookingInput input) {
        var booking = bookingService.createBooking(
            input.getIdRoom(),
            input.getIdHotel(),
            input.getIdGuest(),
            input.getGuestEmail(),
            input.getGuestPhone(),
            input.getCheckIn(),
            input.getCheckOut()
        );

        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
}
