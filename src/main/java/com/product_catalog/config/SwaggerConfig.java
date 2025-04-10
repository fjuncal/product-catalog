package com.product_catalog.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI catalogOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Product Catalog API")
                        .description("API for e-commerce product catalog")
                        .version("v1.0")
                        .contact(new Contact().name("Your Name").email("your.email@example.com")));
    }
}
