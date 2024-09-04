package br.com.baracho.hm.infrastructure.config.dependencyInjection.core.application.service.hotel;

import br.com.baracho.hm.core.application.repository.hotel.FindHotelsByLocaleRepository;
import br.com.baracho.hm.core.application.service.hotel.HotelServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HotelServiceConfig {
    @Bean
    public HotelServiceImpl hotelService(
        FindHotelsByLocaleRepository findHotelsByLocaleRepository
    ) {
        return new HotelServiceImpl(
            findHotelsByLocaleRepository
        );
    }
}
