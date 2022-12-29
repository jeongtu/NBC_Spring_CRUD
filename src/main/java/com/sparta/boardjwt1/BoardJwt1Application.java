package com.sparta.boardjwt1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BoardJwt1Application {

    public static void main(String[] args) {
        SpringApplication.run(BoardJwt1Application.class, args);
    }

}
