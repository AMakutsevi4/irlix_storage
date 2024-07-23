package ru.example.irlix_storage.candy_factory.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.example.irlix_storage.candy_factory.model.Supplie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SupplieRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Supplie> getAllSupplies() {
        List<Supplie> supplieList = new ArrayList<>();
        jdbcTemplate.query("SELECT * FROM supplie", rs -> {
            Supplie supplie = new Supplie();
            supplie.setId(rs.getLong("id"));
            supplie.setCompany(rs.getString("company"));
            supplie.setAddress(rs.getString("address"));

            supplieList.add(supplie);
        });
        return supplieList;
    }

    public Optional<Supplie> getBySupplieId(Long id) {
        List<Supplie> supplieList = new ArrayList<>();
        jdbcTemplate.query("SELECT * FROM supplie WHERE id = ?", new Object[]{id}, rs -> {
            Supplie supplie = new Supplie();
            supplie.setId(rs.getLong("id"));
            supplie.setCompany(rs.getString("company"));
            supplie.setAddress(rs.getString("address"));
            supplieList.add(supplie);
        });
        return supplieList
                .stream().
                findFirst();
    }

    public void saveSupplie(Supplie supplie) {
        if (supplie.getId() != null) {
            updateSupplie(supplie);
        } else {
            jdbcTemplate.update("INSERT INTO supplie (company, address) VALUES (?, ?)",
                    supplie.getCompany(), supplie.getAddress());

        }
    }

    public void updateSupplie(Supplie supplie) {
        jdbcTemplate.update("UPDATE supplie SET company = ?, address = ? WHERE id = ?",
                supplie.getCompany(), supplie.getAddress(), supplie.getId());
    }

    public void deleteSupplie(Long id) {
        jdbcTemplate.update("DELETE FROM supplie WHERE id = ?", id);
    }
}