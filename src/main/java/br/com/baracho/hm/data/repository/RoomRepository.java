package br.com.baracho.hm.data.repository;

import br.com.baracho.hm.data.schema.RoomSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<RoomSchema, UUID> {

    @Query(value = "SELECT r.* FROM room r " +
        "JOIN hotel h ON r.id_hotel = h.id_hotel " +
        "JOIN hotel_address ha ON h.id_hotel = ha.id_hotel " +
        "WHERE LOWER(ha.locale) LIKE LOWER(CONCAT('%', ':locale', '%')) " +
        "AND NOT EXISTS (" +
        "   SELECT 1 FROM booking gr " +
        "   WHERE gr.id_room = r.id_room " +
        "   AND (:check_in_date < gr.check_out_date AND :check_out_date > gr.check_in_date)" +
        ")",
        nativeQuery = true
    )
    List<RoomSchema> findRoomsAvailableByLocaleAndDate(
        @Param("locale") String locale,
        @Param("check_in_date") LocalDate checkInDate,
        @Param("check_out_date") LocalDate checkOutDate
    );
}
