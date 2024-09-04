package br.com.baracho.hm.infrastructure.resource.hotel.controller;

import br.com.baracho.hm.core.application.service.hotel.HotelService;
import br.com.baracho.hm.core.domain.model.hotel.entities.HotelDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/find-by-locale")
    public List<HotelDomain> findHotelByLocale(
        @Param("locale") String locale
    ) {
        return hotelService.findHotelByLocale(locale);
    }
}
