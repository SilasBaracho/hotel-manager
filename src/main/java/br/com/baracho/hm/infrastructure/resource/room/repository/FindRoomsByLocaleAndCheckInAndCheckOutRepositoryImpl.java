package br.com.baracho.hm.infrastructure.resource.room.repository;

import br.com.baracho.hm.core.application.repository.room.FindRoomsByLocaleAndCheckInAndCheckOutRepository;
import br.com.baracho.hm.core.domain.model.entities.RoomDomain;
import br.com.baracho.hm.data.mapper.RoomMapper;
import br.com.baracho.hm.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindRoomsByLocaleAndCheckInAndCheckOutRepositoryImpl implements FindRoomsByLocaleAndCheckInAndCheckOutRepository {
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<RoomDomain> execute(String locale, LocalDate checkIn, LocalDate checkOut) {
        return roomRepository.findRoomsAvailableByLocaleAndDate(locale, checkIn, checkOut)
            .stream()
            .map(roomMapper::toDomain)
            .collect(Collectors.toList());
    }
}
