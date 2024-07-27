package ru.example.irlix_storage.candy_factory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.irlix_storage.candy_factory.model.Supplie;
import ru.example.irlix_storage.candy_factory.repository.SupplieRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplieService {

    private final SupplieRepository supplieRepo;

    public Object getAll() {
        return supplieRepo.findAll();
    }

    public void save(Supplie supplie) {
        if (supplie.getId() != null) {
            supplieRepo.save(supplie);
        } else {
            supplieRepo.save(supplie);
        }
    }

    public Optional<Supplie> getById(Long id) {
        return supplieRepo.findById(id);
    }

    public void delete(Supplie supplie) {
        supplieRepo.delete(supplie);
    }
}
