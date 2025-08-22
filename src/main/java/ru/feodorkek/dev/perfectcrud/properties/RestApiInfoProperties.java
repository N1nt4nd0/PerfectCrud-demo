package ru.feodorkek.dev.perfectcrud.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("rest-api.info")
public class RestApiInfoProperties {

    private String title;
    private String version;
    private String authorEmail;

}
