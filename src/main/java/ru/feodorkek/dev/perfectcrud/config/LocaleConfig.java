package ru.feodorkek.dev.perfectcrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.util.Locale;

@Configuration
public class LocaleConfig {

    @Bean
    public FixedLocaleResolver localeResolver() {
        return new FixedLocaleResolver(Locale.ENGLISH);
    }

}
