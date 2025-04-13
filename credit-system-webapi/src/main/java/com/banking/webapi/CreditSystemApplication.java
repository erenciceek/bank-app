package com.banking.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.banking.core",
        "com.banking.entities",
        "com.banking.repositories",
        "com.banking.business",
        "com.banking.webapi"
})
@EntityScan(basePackages = "com.banking.entities")
@EnableJpaRepositories(basePackages = "com.banking.repositories")
public class CreditSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(CreditSystemApplication.class, args);
    }
} 