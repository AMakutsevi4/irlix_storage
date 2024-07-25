package ru.example.irlix_storage.candy_factory.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.irlix_storage.candy_factory.model.Type;
import ru.example.irlix_storage.candy_factory.repository.TypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    public List<Type> getAll() {
        return typeRepository.findAll();
    }

    public Type getById(Long id) {
        return typeRepository.findById(id).orElse(null);
    }

    public void save(Type type) {
        typeRepository.save(type);
    }

    public void delete(Long id) {
        typeRepository.deleteById(id);
    }
}

