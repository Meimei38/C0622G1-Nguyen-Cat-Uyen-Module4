package product_management.service;

import product_management.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    List<Product>findByName(String searchName);
    void save(Product product);
    Product findById(int id);
    void update(int id, Product product);
    void remove(int id);
    int setId();
}
