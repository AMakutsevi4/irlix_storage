package ru.example.irlix_storage.webApp.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.example.irlix_storage.webApp.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PersonRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        List<Person> personList = new ArrayList<>();
        jdbcTemplate.query("SELECT * FROM people", rs -> {

            Person person = new Person();
            person.setId(rs.getLong("id"));
            person.setName(rs.getString("name"));
            person.setAge(rs.getInt("age"));

            personList.add(person);
        });
        return personList;
    }

    public Optional<Person> findById(Long id) {
        List<Person> personList = new ArrayList<>();
        jdbcTemplate.query("SELECT * FROM people WHERE id = ?", new Object[]{id}, rs -> {

            Person person = new Person();
            person.setId(rs.getLong("id"));
            person.setName(rs.getString("name"));
            person.setAge(rs.getInt("age"));

            personList.add(person);
        });
        return personList
                .stream().
                findFirst();
    }

    public void save(Person person) {
        if (person.getId() == null) {
            jdbcTemplate.update("INSERT INTO people (name, age) VALUES (?, ?)",
                    person.getName(), person.getAge());
        } else {
            jdbcTemplate.update("UPDATE people SET name = ?, age = ? WHERE id = ?",
                    person.getName(), person.getAge(), person.getId());
        }
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM people WHERE id = ?", id);
    }
}
