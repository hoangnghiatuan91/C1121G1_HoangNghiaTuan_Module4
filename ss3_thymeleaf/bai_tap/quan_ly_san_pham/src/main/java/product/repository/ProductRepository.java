package product.repository;

import product.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Car", 100000.0, "Black"));
        products.put(2, new Product(2, "Bike", 50000.0, "Red"));
        products.put(3, new Product(3, "MotorBike", 90000.0, "Grey"));


    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
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
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>(products.values()) ;
        List<Product> productReturn = new ArrayList<>();
        for(Product p:productList){
            if(p.getName().contains(name)){
                productReturn.add(p);
            }
        }
        return productReturn;
    }
}
