package br.com.baracho.hm.data.repository;

import br.com.baracho.hm.data.schema.HotelSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface HotelRepository extends JpaRepository<HotelSchema, UUID> {

//    @Query("SELECT h FROM Hotel h " +
//        "WHERE h.availableRooms >= :rooms " +
//        "AND h.availableGuests >= :guests " +
//        "AND h.checkInDate <= :checkIn " +
//        "AND h.checkOutDate >= :checkOut")
//    List<HotelSchema> findByLocationAndAvailability(
//        @Param("checkIn") LocalDate checkIn,
//        @Param("checkOut") LocalDate checkOut,
//        @Param("rooms") int rooms,
//        @Param("guests") int guests
//    );

    @Query(value = "SELECT h.* " +
        "FROM hotel h JOIN hotel_address ha ON h.id_hotel = ha.id_hotel " +
        "WHERE ha.locale = :locale",
        nativeQuery = true
    )
    List<HotelSchema> findHotelsByLocale(
        @Param("locale") String locale
    );

}
