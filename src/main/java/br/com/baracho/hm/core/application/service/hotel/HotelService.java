package br.com.baracho.hm.core.application.service.hotel;

import br.com.baracho.hm.core.domain.model.entities.HotelDomain;

import java.util.List;

public interface HotelService {
    List<HotelDomain> findHotelByLocale(String locale);
}
