package br.com.baracho.hm.infrastructure.resource.room.controller;

import br.com.baracho.hm.core.application.service.hotel.HotelService;
import br.com.baracho.hm.core.application.service.room.RoomService;
import br.com.baracho.hm.core.domain.model.entities.HotelDomain;
import br.com.baracho.hm.core.domain.model.entities.RoomDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/find-room-available")
    public List<RoomDomain> findRoomAvailable(
        @Param("id_hotel") String locale,
        @Param("check_in") LocalDate checkIn,
        @Param("check_out") LocalDate checkOut
    ) {
        return roomService.findRoomsAvailable(locale, checkIn, checkOut);
    }
}
