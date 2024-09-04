package br.com.baracho.hm.core.domain.model.hotel.entities;

import br.com.baracho.hm.core.domain.model.hotel.enums.RoomTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class RoomDomain {
    private UUID id;

    private BigDecimal pricePerNight;

    private RoomTypeEnum roomType;

    private Integer numberGuests;

    private Integer roomNumber;

    private Integer floor;

    private Integer isAvailable;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private HotelDomain hotelDomain;
}
