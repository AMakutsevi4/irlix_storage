package ru.example.irlix_storage.candy_factory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.irlix_storage.candy_factory.model.Owner;
import ru.example.irlix_storage.candy_factory.repository.OwnerRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepo;

    public Object getAll() {
        return ownerRepo.findAll();
    }

    public void save(Owner owner) {
        ownerRepo.save(owner);
    }

    public Optional<Owner> getById(Long id) {
        return ownerRepo.findById(id);
    }

    public void delete(Owner owner) {
        ownerRepo.delete(owner);
    }
}
