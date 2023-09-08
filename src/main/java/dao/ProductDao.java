package dao;
import entity.Product;

import java.util.List;

public interface ProductDao {

    void saveProduct(Product products);

    List<Product> findAll();
}
