package product_management.service.impl;

import org.springframework.stereotype.Service;
import product_management.model.Product;
import product_management.service.IProductService;

import java.util.*;

@Service
public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {
        products = new LinkedHashMap<>();
        products.put(1, new Product(1, "Xiaomi", 2300000.0, "Nhập khẩu", "Xiaomi"));
        products.put(2, new Product(2, "IPhoneX", 12300000.0, "Nhập khẩu", "Apple"));
        products.put(3, new Product(3, "Samsung 7S", 4300000.0, "Nhập khẩu", "Samsung"));
        products.put(4, new Product(4, "IPhone14Pro", 9300000.0, "Nhập khẩu", "Apple"));
        products.put(5, new Product(5, "Nokia123", 8200000.0, "Nhập khẩu", "Nokia"));
        products.put(6, new Product(6, "Xiaomi 9X", 11300000.0, "Nhập khẩu", "Xiaomi"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public List<Product> findByName(String searchName) {
        List<Product> productList = new ArrayList<>();
        for(Integer key:products.keySet()){
            if( products.get(key).getName().contains(searchName)){
                productList.add(products.get(key));
            }
        }
        return productList;
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);

    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public int setId() {
        int idProduct = products.get(products.size()).getId();
        idProduct+=1;
        return idProduct;
    }
}
