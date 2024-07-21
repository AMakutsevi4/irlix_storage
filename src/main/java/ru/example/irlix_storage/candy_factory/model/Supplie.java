package ru.example.irlix_storage.candy_factory.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplie {
    private Long id;
    @NotBlank(message = "Название не должно быть пустым")
    private String company;
    @NotBlank(message = "Адресс не может быть пустым")
    private String address;
}
