package br.com.baracho.hm.core.application.repository.hotel;

import br.com.baracho.hm.core.domain.model.entities.HotelDomain;
import java.util.Optional;
import java.util.UUID;

public interface FindHotelByIdRepository {
    Optional<HotelDomain> execute(UUID idHotel);
}
