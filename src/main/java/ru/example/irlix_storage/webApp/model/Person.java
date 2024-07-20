package ru.example.irlix_storage.webApp.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class Person {

    private Long id;

    @NotBlank(message = "Имя не должно быть пустым")
    private String name;

    @Positive(message = "Возраст должен быть положительным числом")
    private int age;
}
