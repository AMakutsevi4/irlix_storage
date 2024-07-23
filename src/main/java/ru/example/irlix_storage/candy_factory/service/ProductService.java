package ru.example.irlix_storage.candy_factory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.irlix_storage.candy_factory.model.Product;
import ru.example.irlix_storage.candy_factory.model.Supplie;
import ru.example.irlix_storage.candy_factory.repository.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepo;
    private final SupplieService supplieService;

    public List<Product> getAll() {
        return productRepo.findAll();
    }

    public List<Supplie> getAllSupplies() {
        return supplieService.getAll();
    }

    public Map<Long, String> productSupplyMap() {
        List<Product> products = productRepo.findAll();
        Map<Long, String> supplierNames = new HashMap<>();
        for (Product product : products) {
            Supplie supplie = supplieService.getById(product.getSupplie_Id()).orElse(null);
            supplierNames.put(product.getId(), supplie.getCompany());
        }
        return supplierNames;
    }

    public void save(Product product) {
        productRepo.save(product);
    }

    public Product getById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    public void update(Product product) {
        productRepo.save(product);
    }

    public void delete(Product product) {
        productRepo.delete(product);
    }
}