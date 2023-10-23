package com.price.system.price.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.price.system.price.*"})
@EntityScan(basePackages = { "com.price.system.price.*"})
@SpringBootApplication(scanBasePackages = "com.price.system")
public class PriceServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PriceServiceApplication.class,args);
    }

}
