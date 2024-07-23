package ru.example.irlix_storage.candy_factory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.example.irlix_storage.candy_factory.model.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {

}