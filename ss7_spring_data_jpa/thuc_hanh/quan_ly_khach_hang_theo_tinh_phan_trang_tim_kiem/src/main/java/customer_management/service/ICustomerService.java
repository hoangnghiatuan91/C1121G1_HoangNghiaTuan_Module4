package customer_management.service;

import customer_management.model.Customer;
import customer_management.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(String name,Pageable pageable);

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

//    Page<Customer> findAllByFirstNameContaining(String name,Pageable pageable);
}
