package br.com.baracho.hm.core.domain.model.entities;

import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class HotelDomain {
    private UUID id;

    private String name;

    private LocalTime checkInTime;

    private LocalTime checkOutTime;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Builder
    public HotelDomain(UUID id, String name, LocalTime checkInTime, LocalTime checkOutTime, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id != null ? id : UUID.randomUUID() ;
        this.name = name;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt;
    }
}
