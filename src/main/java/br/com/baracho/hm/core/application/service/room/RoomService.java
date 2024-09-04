package br.com.baracho.hm.core.application.service.room;

import br.com.baracho.hm.core.domain.model.entities.RoomDomain;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface RoomService {
    List<RoomDomain> findRoomsAvailable(String locale, LocalDate checkIn, LocalDate checkOut);
}
