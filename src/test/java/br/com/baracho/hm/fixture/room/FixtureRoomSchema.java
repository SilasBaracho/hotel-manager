package br.com.baracho.hm.fixture.room;

import br.com.baracho.hm.core.domain.model.entities.RoomDomain;
import br.com.baracho.hm.data.mapper.RoomMapper;
import br.com.baracho.hm.data.schema.RoomSchema;

public class FixtureRoomSchema {
    private final RoomMapper roomMapper = new RoomMapper();

    public RoomSchema getFixtureRoomSchema(RoomDomain roomDomain) {
        return roomMapper.toSchema(roomDomain);
    }
}
