package br.com.baracho.hm.infrastructure.resource.room.repository;

import br.com.baracho.hm.core.application.repository.room.SaveRoomRepository;
import br.com.baracho.hm.core.domain.model.entities.RoomDomain;
import br.com.baracho.hm.data.mapper.RoomMapper;
import br.com.baracho.hm.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveRoomRepositoryImpl implements SaveRoomRepository {
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public RoomDomain execute(RoomDomain roomDomain) {
        var roomSaved = roomRepository.save(roomMapper.toSchema(roomDomain));
        return roomMapper.toDomain(roomSaved);
    }
}
