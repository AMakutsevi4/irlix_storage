package ru.example.irlix_storage.candy_factory.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Наименование не должно быть пустым")
    private String name;
    @Positive(message = "Стоимость должна быть положительным числом")
    private int price;
    @Positive(message = "Калории должны быть положительным числом")
    private int calories;

    @Column(name = "supplie_id")
    private Long supplie_Id;
    @NotBlank(message = "Состав не должен быть пустым")
    private String structure;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_type",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    private List<Type> types;
}
