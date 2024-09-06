package br.com.baracho.hm.core.domain.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotificationPurposeEnum {
    BOOKING_CONFIRMED("BOOKING_CONFIRMED", "Reserva confirmada"),
    BOOKING_PROCESSING("BOOKING_PROCESSING", "Processando reserva");

    private final String action;
    private final String subject;
}
