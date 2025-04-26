package com.hellteam.hellzic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class HellZicApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellZicApplication.class, args);
    }

}
