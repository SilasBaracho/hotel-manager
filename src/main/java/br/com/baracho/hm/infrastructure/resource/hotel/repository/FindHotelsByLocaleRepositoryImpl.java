package br.com.baracho.hm.infrastructure.resource.hotel.repository;

import br.com.baracho.hm.core.application.repository.hotel.FindHotelsByLocaleRepository;
import br.com.baracho.hm.core.domain.model.entities.HotelDomain;
import br.com.baracho.hm.data.mapper.HotelMapper;
import br.com.baracho.hm.data.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindHotelsByLocaleRepositoryImpl implements FindHotelsByLocaleRepository {
    @Autowired
    private HotelMapper hotelMapper;
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<HotelDomain> execute(String locale) {
        return hotelRepository.findHotelsByLocale(locale)
            .stream()
            .map(hotelMapper::toDomain)
            .collect(Collectors.toList()
        );
    }
}
