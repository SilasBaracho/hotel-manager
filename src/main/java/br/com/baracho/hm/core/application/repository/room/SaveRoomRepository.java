package br.com.baracho.hm.core.application.repository.room;

import br.com.baracho.hm.core.domain.model.entities.RoomDomain;

public interface SaveRoomRepository {
    RoomDomain execute(RoomDomain roomDomain);
}
