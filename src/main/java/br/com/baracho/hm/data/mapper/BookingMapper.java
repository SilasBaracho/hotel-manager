package br.com.baracho.hm.data.mapper;

import br.com.baracho.hm.core.domain.model.entities.BookingDomain;
import br.com.baracho.hm.core.domain.model.entities.RoomDomain;
import br.com.baracho.hm.data.schema.BookingSchema;
import br.com.baracho.hm.data.schema.RoomSchema;
import br.com.baracho.hm.infrastructure.config.kafka.avro.CreateBookingAvro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper implements Mapper<BookingDomain, BookingSchema> {
    @Autowired
    private HotelMapper hotelMapper;
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public BookingDomain toDomain(BookingSchema bookingSchema) {
        return BookingDomain.builder()
            .id(bookingSchema.getId())
            .idGuest(bookingSchema.getIdGuest())
            .guestEmail(bookingSchema.getGuestEmail())
            .guestPhone(bookingSchema.getGuestPhone())
            .status(bookingSchema.getStatus())
            .createdAt(bookingSchema.getCreatedAt())
            .updatedAt(bookingSchema.getUpdatedAt())
            .checkInDate(bookingSchema.getCheckInDate())
            .checkOutDate(bookingSchema.getCheckOutDate())
            .hotelDomain(hotelMapper.toDomain(bookingSchema.getHotelSchema()))
            .roomDomain(roomMapper.toDomain(bookingSchema.getRoomSchema()))
            .build();
    }

    @Override
    public BookingSchema toSchema(BookingDomain bookingDomain) {
        return BookingSchema.builder()
            .id(bookingDomain.getId())
            .idGuest(bookingDomain.getIdGuest())
            .guestEmail(bookingDomain.getGuestEmail())
            .guestPhone(bookingDomain.getGuestPhone())
            .status(bookingDomain.getStatus())
            .createdAt(bookingDomain.getCreatedAt())
            .updatedAt(bookingDomain.getUpdatedAt())
            .checkInDate(bookingDomain.getCheckInDate())
            .checkOutDate(bookingDomain.getCheckOutDate())
            .hotelSchema(hotelMapper.toSchema(bookingDomain.getHotelDomain()))
            .roomSchema(roomMapper.toSchema(bookingDomain.getRoomDomain()))
            .build();
    }
}
