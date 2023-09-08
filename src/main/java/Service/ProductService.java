package dao;

import entity.Product;

import java.util.List;

public class ProductService {

    private final ProductDaoImpl productDao = new ProductDaoImpl();

    public void saveProduct() {
        Product products = new Product();
        products.setNname("Shampoo");
        products.setQuantity(3);
        productDao.saveProduct(products);
    }

    public List <Product> getAllProducts(){
        return productDao.findAll();
    }
}
