package product.repository;


import org.springframework.stereotype.Repository;
import product.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery = entityManager.createQuery("select p from " +
            " product p ", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product);

    }

    @Override
    public Product findById(int id) {
//        TypedQuery<Product> typedQuery = entityManager.createQuery("select p " +
//                "from product p " +
//                "where p.id = ?1", Product.class);
//        typedQuery.setParameter(1, id);
       return entityManager.find(Product.class,id);
    }

    @Override
    public void update(int id, Product product) {
        entityManager.merge(product);

    }

    @Override
    public void remove(int id) {
        Product product = this.findById(id);
        entityManager.remove(product);

    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>(this.findAll());
        List<Product> productReturn = new ArrayList<>();
        for (Product p : productList) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                productReturn.add(p);
            }
        }
        return productReturn;
    }
}
//package product.repository;
//
//import org.springframework.stereotype.Repository;
//import product.model.Product;
//import product.repository.IProductRepository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.transaction.Transactional;
//import java.util.List;
//@Transactional
//@Repository
//public class ProductRepository implements IProductRepository {
//    @PersistenceContext
//    private EntityManager entityManager;
//    @Override
//    public List<Product> findAll() {
//        TypedQuery<Product> typedQuery = entityManager.
//                createQuery("select p from product p", Product.class);
//        return typedQuery.getResultList();
//    }
//
//}