package br.com.baracho.hm.infrastructure.config.dependencyInjection.core.application.service.room;

import br.com.baracho.hm.core.application.repository.room.FindRoomsByLocaleAndCheckInAndCheckOutRepository;
import br.com.baracho.hm.core.application.service.room.RoomServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoomServiceConfig {
    @Bean
    public RoomServiceImpl roomService(
        FindRoomsByLocaleAndCheckInAndCheckOutRepository findRoomsByCheckInAndCheckOutRepository
    ) {
        return new RoomServiceImpl(
            findRoomsByCheckInAndCheckOutRepository
        );
    }
}
