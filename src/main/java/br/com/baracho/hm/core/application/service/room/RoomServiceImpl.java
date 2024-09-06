package br.com.baracho.hm.core.application.service.room;

import br.com.baracho.hm.core.application.repository.room.FindRoomsByLocaleAndCheckInAndCheckOutRepository;
import br.com.baracho.hm.core.domain.model.entities.RoomDomain;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class RoomServiceImpl implements RoomService {
    private final FindRoomsByLocaleAndCheckInAndCheckOutRepository findRoomsByLocaleAndCheckInAndCheckOutRepository;

    public RoomServiceImpl(
        FindRoomsByLocaleAndCheckInAndCheckOutRepository findRoomsByLocaleAndCheckInAndCheckOutRepository
    ) {
        this.findRoomsByLocaleAndCheckInAndCheckOutRepository = findRoomsByLocaleAndCheckInAndCheckOutRepository;
    }

    @Override
    public List<RoomDomain> findRoomsAvailable(String locale, LocalDate checkIn, LocalDate checkOut) {
        return findRoomsByLocaleAndCheckInAndCheckOutRepository.execute(locale, checkIn, checkOut);
    }
}
