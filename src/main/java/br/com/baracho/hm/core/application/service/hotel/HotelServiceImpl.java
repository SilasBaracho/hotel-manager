package br.com.baracho.hm.core.application.service.hotel;

import br.com.baracho.hm.core.application.repository.hotel.FindHotelsByLocaleRepository;
import br.com.baracho.hm.core.domain.model.entities.HotelDomain;

import java.util.List;

public class HotelServiceImpl implements HotelService {
    private final FindHotelsByLocaleRepository findHotelsByLocaleRepository;

    public HotelServiceImpl(
        FindHotelsByLocaleRepository findHotelsByLocaleRepository
    ) {
        this.findHotelsByLocaleRepository = findHotelsByLocaleRepository;
    }

    @Override
    public List<HotelDomain> findHotelByLocale(String locale) {
        return findHotelsByLocaleRepository.execute(locale);
    }
}
