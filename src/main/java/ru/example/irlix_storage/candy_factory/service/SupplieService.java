package ru.example.irlix_storage.candy_factory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.irlix_storage.candy_factory.model.Supplie;
import ru.example.irlix_storage.candy_factory.repository.SupplieRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplieService {

    private final SupplieRepository supplieRepo;

    public List<Supplie> getAll() {
        return supplieRepo.getAllSupplies();
    }

    public void save(Supplie supplie) {
        supplieRepo.saveSupplie(supplie);
    }

    public Optional<Supplie> getById(Long id) {
        return supplieRepo.getBySupplieId(id);
    }

    public void delete(Long id) {
        supplieRepo.deleteSupplie(id);
    }
}
