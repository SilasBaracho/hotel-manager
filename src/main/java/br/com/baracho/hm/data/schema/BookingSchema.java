package br.com.baracho.hm.data.schema;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "booking")
public class BookingSchema {
    @Id
    @Column(name = "booking")
    private UUID id;

    @Column(name = "id_guest")
    private UUID idGuest;

    @Column(name = "id_room")
    private UUID idRoom;

    @Column(name = "id_hotel")
    private UUID idHotel;

    @Column(name = "status")
    private String status;

    @Column(name = "check_in_date")
    private LocalDate checkInDate;

    @Column(name = "check_out_date")
    private LocalDate checkOutDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}

