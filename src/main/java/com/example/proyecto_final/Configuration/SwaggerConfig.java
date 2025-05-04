package com.example.proyecto_final.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Proyecto final")
                        .version("1.0")
                        .description("Documentación de la API para el proyecto final")
                        .contact(new Contact()
                                .name("Andres Guayacan")
                                .name("Santiago Alarcon")));
    }
}
