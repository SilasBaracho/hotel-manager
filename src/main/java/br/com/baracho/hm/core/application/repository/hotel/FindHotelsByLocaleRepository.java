package br.com.baracho.hm.core.application.repository.hotel;

import br.com.baracho.hm.core.domain.model.entities.HotelDomain;

import java.util.List;

public interface FindHotelsByLocaleRepository {
    List<HotelDomain> execute(String locale);
}
