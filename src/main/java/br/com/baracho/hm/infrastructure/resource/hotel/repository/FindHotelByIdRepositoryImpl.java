package br.com.baracho.hm.infrastructure.resource.hotel.repository;

import br.com.baracho.hm.core.application.repository.hotel.FindHotelByIdRepository;
import br.com.baracho.hm.core.domain.model.entities.HotelDomain;
import br.com.baracho.hm.data.mapper.HotelMapper;
import br.com.baracho.hm.data.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class FindHotelByIdRepositoryImpl implements FindHotelByIdRepository {
    @Autowired
    private HotelMapper hotelMapper;
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Optional<HotelDomain> execute(UUID idHotel) {
        return hotelRepository.findById(idHotel).map(hotelMapper::toDomain);
    }
}
