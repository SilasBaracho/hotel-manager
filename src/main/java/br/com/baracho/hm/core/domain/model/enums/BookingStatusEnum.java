package br.com.baracho.hm.core.domain.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BookingStatusEnum {
    PENDING,
    CONFIRMED,
    CANCELED
}
