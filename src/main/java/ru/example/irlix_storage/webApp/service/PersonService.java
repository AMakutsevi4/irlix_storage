package ru.example.irlix_storage.webApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.irlix_storage.webApp.model.Person;
import ru.example.irlix_storage.webApp.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepo;

    public List<Person> findAll() {
        return personRepo.findAll();
    }

    public Optional<Person> findById(Long id) {
        return personRepo.findById(id);
    }

    public void save(Person person) {
        personRepo.save(person);
    }

    public void deleteById(Long id) {
        personRepo.deleteById(id);
    }

}
