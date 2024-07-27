package ru.example.irlix_storage.candy_factory.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.example.irlix_storage.candy_factory.model.Product;
import ru.example.irlix_storage.candy_factory.model.Supplie;
import ru.example.irlix_storage.candy_factory.model.Type;
import ru.example.irlix_storage.candy_factory.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepo;
    private final SupplieService supplieService;
    private final TypeService typeService;

    public List<Product> getAll() {
        return productRepo.findAll();
    }

    public Object getAllSupplies() {
        return supplieService.getAll();
    }

    public Map<Long, String> productSupplyMap() {
        List<Product> products = productRepo.findAll();
        Map<Long, String> supplierNames = new HashMap<>();
        for (Product product : products) {
            Supplie supplie = supplieService.getById(product.getSupplie_Id()).get();
            supplierNames.put(product.getId(), supplie.getCompany());
        }
        return supplierNames;
    }

    public List<Type> getAllTypes(Product product) {
        List<Type> selectedTypes = new ArrayList<>();
        for (Type type : product.getTypes()) {
            selectedTypes.add(typeService.getById(type.getId()));
        }
        return selectedTypes;
    }

    public void save(Product product) {
        logger.debug("СОхранение продукта в репозитории: {}", product);
        productRepo.save(product);
        logger.debug("Пррдукт сохранен в сервисет");
    }

    public Product getById(Long id) {
        return productRepo.findById(id);
    }

    public void update(Product product) {
        productRepo.update(product);
    }

    public void delete(Product product) {
        productRepo.delete(product);
    }
}