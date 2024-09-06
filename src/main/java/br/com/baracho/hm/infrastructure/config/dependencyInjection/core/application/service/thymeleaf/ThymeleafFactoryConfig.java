package br.com.baracho.hm.infrastructure.config.dependencyInjection.core.application.service.thymeleaf;

import br.com.baracho.hm.core.application.service.thymeleaf.ThymeleafService;
import br.com.baracho.hm.core.application.service.thymeleaf.ThymeleafServiceImpl;
import br.com.baracho.hm.core.application.service.thymeleaf.strategy.ThymeleafStrategy;
import br.com.baracho.hm.core.application.service.thymeleaf.strategy.BookingProcessingEmailThymeleafStrategy;
import br.com.baracho.hm.core.application.service.thymeleaf.strategy.BookingConfirmedEmailThymeleafStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;

import java.util.List;

@Configuration
public class ThymeleafFactoryConfig {
    @Bean
    public ThymeleafService thymeleafService(List<ThymeleafStrategy> strategies) {
        return new ThymeleafServiceImpl(strategies);
    }

    @Bean
    public BookingConfirmedEmailThymeleafStrategy verifyPhoneNumberThymeleafStrategy(
        @Qualifier("emailTemplateEngine") TemplateEngine emailTemplateEngine
    ) {
        return new BookingConfirmedEmailThymeleafStrategy(emailTemplateEngine);
    }

    @Bean
    public BookingProcessingEmailThymeleafStrategy verifyEmailThymeleafStrategy(
        @Qualifier("emailTemplateEngine") TemplateEngine emailTemplateEngine
    ) {
        return new BookingProcessingEmailThymeleafStrategy(emailTemplateEngine);
    }
}
