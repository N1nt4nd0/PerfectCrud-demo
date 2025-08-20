package ru.feodorkek.dev.perfectcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PerfectCrudApplication {

	public static void main(final String[] args) {
		SpringApplication.run(PerfectCrudApplication.class, args);
	}

}
