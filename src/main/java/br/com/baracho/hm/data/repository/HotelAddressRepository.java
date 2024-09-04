package br.com.baracho.hm.data.repository;

import br.com.baracho.hm.data.schema.HotelAddressSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HotelAddressRepository extends JpaRepository<HotelAddressSchema, UUID> {
}
