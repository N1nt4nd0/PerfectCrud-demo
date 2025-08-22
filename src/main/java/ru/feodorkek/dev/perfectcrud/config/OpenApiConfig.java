package ru.feodorkek.dev.perfectcrud.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.feodorkek.dev.perfectcrud.properties.RestApiInfoProperties;

@Configuration
@RequiredArgsConstructor
public class OpenApiConfig {

    private final RestApiInfoProperties apiInfo;

    @Bean
    public OpenAPI openApiDefinition() {
        return new OpenAPI().info(new Info()
                .title(apiInfo.getTitle())
                .version(apiInfo.getVersion())
                .contact(new Contact().email(apiInfo.getAuthorEmail())));
    }

}
