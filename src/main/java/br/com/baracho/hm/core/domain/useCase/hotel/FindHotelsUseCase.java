package br.com.baracho.hm.core.domain.useCase.hotel;

import br.com.baracho.hm.core.domain.model.entities.HotelDomain;

import java.util.List;

public interface FindHotelsUseCase {
    List<HotelDomain> execute();
}
