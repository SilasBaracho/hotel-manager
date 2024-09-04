package br.com.baracho.hm.data.repository;

import br.com.baracho.hm.data.schema.BookingSchema;
import br.com.baracho.hm.data.schema.RoomSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookingRepository extends JpaRepository<BookingSchema, UUID> {
    Optional<BookingSchema> findByIdGuest(UUID idGuest);
}
