package ru.example.irlix_storage.candy_factory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Имя не должно быть пустым")
    private String first_name;
    @NotBlank(message = "Фамилия не должна быть пустой")
    private String last_name;
    @Positive(message = "Возраст должен быть положительным числом")
    private int phone_number;
    @NotBlank(message = "Email не должен быть пустым")
    @Email(message = "Неверный формат email")
    private String email;
}
