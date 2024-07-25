package ru.example.irlix_storage.candy_factory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.irlix_storage.candy_factory.model.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
}
