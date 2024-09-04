package br.com.baracho.hm.core.domain.model.entities;

import br.com.baracho.hm.core.domain.model.enums.BookingStatusEnum;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BookingDomain {
    private UUID id;

    private UUID idGuest;

    private BookingStatusEnum status;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private RoomDomain roomDomain;

    private HotelDomain hotelDomain;

    @Builder
    public BookingDomain(UUID id, UUID idGuest, BookingStatusEnum status, LocalDate checkInDate, LocalDate checkOutDate, LocalDateTime createdAt, LocalDateTime updatedAt, RoomDomain roomDomain, HotelDomain hotelDomain) {
        this.id = id != null ? id : UUID.randomUUID();
        this.idGuest = idGuest;
        this.status = status != null ? status : BookingStatusEnum.PENDING;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();;
        this.updatedAt = updatedAt;
        this.roomDomain = roomDomain;
        this.hotelDomain = hotelDomain;
    }


}
