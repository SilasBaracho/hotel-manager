package br.com.baracho.hm.data.mapper;

import br.com.baracho.hm.core.domain.model.entities.RoomDomain;
import br.com.baracho.hm.data.schema.RoomSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper implements Mapper<RoomDomain, RoomSchema> {
    private final HotelMapper hotelMapper = new HotelMapper();

    @Override
    public RoomDomain toDomain(RoomSchema roomSchema) {
        return RoomDomain.builder()
            .id(roomSchema.getId())
            .pricePerNight(roomSchema.getPricePerNight())
            .roomType(roomSchema.getRoomType())
            .numberGuests(roomSchema.getNumberGuests())
            .roomNumber(roomSchema.getRoomNumber())
            .floor(roomSchema.getFloor())
            .createdAt(roomSchema.getCreatedAt())
            .updatedAt(roomSchema.getUpdatedAt())
            .hotelDomain(hotelMapper.toDomain(roomSchema.getHotelSchema()))
            .build();
    }

    @Override
    public RoomSchema toSchema(RoomDomain roomDomain) {
        return RoomSchema.builder()
            .id(roomDomain.getId())
            .pricePerNight(roomDomain.getPricePerNight())
            .roomType(roomDomain.getRoomType())
            .numberGuests(roomDomain.getNumberGuests())
            .roomNumber(roomDomain.getRoomNumber())
            .floor(roomDomain.getFloor())
            .createdAt(roomDomain.getCreatedAt())
            .updatedAt(roomDomain.getUpdatedAt())
            .hotelSchema(hotelMapper.toSchema(roomDomain.getHotelDomain()))
            .build();
    }
}
