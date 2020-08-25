package com.anthonynavarro.lifehack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LifehackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifehackApplication.class, args);
    }

}
