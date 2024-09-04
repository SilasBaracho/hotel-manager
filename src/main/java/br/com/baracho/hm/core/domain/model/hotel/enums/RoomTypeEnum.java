package br.com.baracho.hm.core.domain.model.hotel.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoomTypeEnum {
    SINGLE_ROOM,
    TWIN_ROOM,
    DOUBLE_ROOM;
//    SINGLE_ROOM("Quarto de solteiro", 1, 1),
//    TWIN_ROOM("Quarto de duplo solteiro", 2, 2),
//    DOUBLE_ROOM("Quarto de casal", 1, 1);
//
//    private final String description;
//    private final Integer numberOfBeds;
//    private final Integer numberOfGuests;
}
