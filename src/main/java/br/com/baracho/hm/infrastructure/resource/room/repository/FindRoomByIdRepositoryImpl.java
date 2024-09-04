package br.com.baracho.hm.infrastructure.resource.room.repository;

import br.com.baracho.hm.core.application.repository.room.FindRoomByIdRepository;
import br.com.baracho.hm.core.domain.model.entities.RoomDomain;
import br.com.baracho.hm.data.mapper.RoomMapper;
import br.com.baracho.hm.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class FindRoomByIdRepositoryImpl implements FindRoomByIdRepository {
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Optional<RoomDomain> execute(UUID idRoom) {
        return roomRepository.findById(idRoom).map(roomMapper::toDomain);
    }
}
