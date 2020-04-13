package org.trooper.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "org.trooper")
@EnableJpaRepositories(basePackages = "org.trooper.dao")
@EntityScan(basePackages = "org.trooper.entity")
public class ItemCatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemCatalogueApplication.class, args);
	}

}
