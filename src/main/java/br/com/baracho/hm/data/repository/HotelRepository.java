package br.com.baracho.hm.data.repository;

import br.com.baracho.hm.data.schema.HotelSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HotelRepository extends JpaRepository<HotelSchema, UUID> {
}
