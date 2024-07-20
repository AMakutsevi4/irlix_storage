package ru.example.irlix_storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IrlixStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(IrlixStorageApplication.class, args);
        System.out.println("Go to: http://localhost:8080/people");
    }

}
