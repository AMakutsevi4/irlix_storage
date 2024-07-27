package ru.example.irlix_storage.candy_factory.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Supplie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Название не должно быть пустым")
    private String  company;
    @NotBlank(message = "Адресс не может быть пустым")
    private String address;
    @OneToOne()
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
