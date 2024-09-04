package br.com.baracho.hm.core.domain.model.entities;

import br.com.baracho.hm.core.domain.model.enums.RoomTypeEnum;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class RoomDomain {
    private UUID id;

    private BigDecimal pricePerNight;

    private RoomTypeEnum roomType;

    private Integer numberGuests;

    private Integer roomNumber;

    private Integer floor;

    private Boolean isAvailable;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private HotelDomain hotelDomain;

    @Builder
    public RoomDomain(UUID id, BigDecimal pricePerNight, RoomTypeEnum roomType, Integer numberGuests, Integer roomNumber, Integer floor, Boolean isAvailable, LocalDateTime createdAt, LocalDateTime updatedAt, HotelDomain hotelDomain) {
        this.id = id != null ? id : UUID.randomUUID();
        this.pricePerNight = pricePerNight;
        this.roomType = roomType;
        this.numberGuests = numberGuests;
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt;
        this.hotelDomain = hotelDomain;
    }
}
