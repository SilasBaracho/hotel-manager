package br.com.baracho.hm.infrastructure.resource.booking.controller.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class BookingInput {
    private UUID idRoom;
    private UUID idHotel;
    private UUID idGuest;
    private String guestEmail;
    private String guestPhone;
    private LocalDate checkIn;
    private LocalDate checkOut;
}
