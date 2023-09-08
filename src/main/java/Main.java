package dao;


public class Main {
    public static void main(String[] args) {

        final ProductService service = new ProductService();
        service.saveProduct();
        service.getAllProducts().forEach(p -> System.out.println(p.getNname()));
    }
}