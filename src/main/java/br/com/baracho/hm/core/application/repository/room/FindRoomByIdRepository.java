package br.com.baracho.hm.core.application.repository.room;

import br.com.baracho.hm.core.domain.model.entities.RoomDomain;

import java.util.Optional;
import java.util.UUID;

public interface FindRoomByIdRepository {
    Optional<RoomDomain> execute(UUID idRoom);
}
