package cart.service;

import cart.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
}
