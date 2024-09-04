package br.com.baracho.hm.data.schema;

import br.com.baracho.hm.core.domain.model.enums.BookingStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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
@Table(name = "booking")
public class BookingSchema {
    @Id
    @Column(name = "id_booking")
    private UUID id;

    @Column(name = "id_guest")
    private UUID idGuest;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookingStatusEnum status;

    @Column(name = "check_in_date")
    private LocalDate checkInDate;

    @Column(name = "check_out_date")
    private LocalDate checkOutDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "id_room")
    private RoomSchema roomSchema;

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private HotelSchema hotelSchema;
}

