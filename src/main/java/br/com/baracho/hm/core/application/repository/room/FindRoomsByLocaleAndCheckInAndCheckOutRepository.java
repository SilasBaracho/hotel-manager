package br.com.baracho.hm.core.application.repository.room;

import br.com.baracho.hm.core.domain.model.entities.RoomDomain;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface FindRoomsByLocaleAndCheckInAndCheckOutRepository {
    List<RoomDomain> execute(String locale, LocalDate checkIn, LocalDate checkOut);
}
