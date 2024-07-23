package ru.example.irlix_storage.candy_factory.repository;


import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.example.irlix_storage.candy_factory.model.Product;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final SessionFactory sf;

    public List<Product> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Product> result = session.createQuery("from ru.example.irlix_storage.candy_factory.model.Product").list();
        session.getTransaction().commit();
        session.close();
        return result;

    }

    public Product save(Product product) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();
        return product;
    }

    public Product findById(Long id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Product result = session.get(Product.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public void update(Product product) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.update(product);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Product product) {
        Session session = sf.openSession();
        session.beginTransaction();

        Product persistentProduct = session.get(Product.class, product.getId());

        session.delete(persistentProduct);
        session.getTransaction().commit();
        session.close();
    }
}
