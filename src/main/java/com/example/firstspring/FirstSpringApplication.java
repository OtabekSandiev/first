package com.example.firstspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;

@SpringBootApplication
public class FirstSpringApplication {

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(FirstSpringApplication.class);
        application.setAdditionalProfiles(args[0]); //profile property
        System.getProperties().setProperty("server.port", args[1]);

        application.run(args);
    }
}
