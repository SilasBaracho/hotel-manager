package br.com.baracho.hm.infrastructure.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationDocConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("hotel-manager-api")
                .description("API responsável gerenciar os quartos do hotel")
                .contact(new Contact()
                    .name("baracho")
                )
            );
    }
}
