package br.com.baracho.hm.core.domain.model.entities;

import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class HotelDomain {
    private UUID id;

    private String name;

    private LocalTime checkInTime;

    private LocalTime checkOutTime;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
