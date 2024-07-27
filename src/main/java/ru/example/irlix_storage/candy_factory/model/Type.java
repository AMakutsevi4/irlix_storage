package ru.example.irlix_storage.candy_factory.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Название не должно быть пустым")
    private String name;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "types")
    /*загружаем коллекцию перед использованием,
    избегаем ошибку LazyInitializationException*/
    @ToString.Exclude
    private List<Product> products;
}
