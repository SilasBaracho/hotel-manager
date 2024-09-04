package br.com.baracho.hm.data.schema;

import br.com.baracho.hm.core.domain.model.hotel.enums.RoomTypeEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

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
@Entity
@Table(name = "ROOM")
public class RoomSchema {
    @Id
    @Column(name = "id_room")
    private UUID id;

    @Column(name = "price_per_night")
    private BigDecimal pricePerNight;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type")
    private RoomTypeEnum roomType;

    @Column(name = "number_guests")
    private Integer numberGuests;

    @Column(name = "room_number")
    private Integer roomNumber;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "is_available")
    private Integer isAvailable;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private HotelSchema hotelSchema;
}
