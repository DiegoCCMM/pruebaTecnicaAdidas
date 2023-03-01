package com.example.restapiversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestApiVersionApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiVersionApplication.class, args);
    }

}
