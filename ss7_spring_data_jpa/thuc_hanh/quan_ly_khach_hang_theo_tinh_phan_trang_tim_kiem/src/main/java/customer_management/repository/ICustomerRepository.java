package customer_management.repository;

import customer_management.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findAllByFirstNameContaining(String name, Pageable pageable);
    Page<Customer> findCustomerByProvince(String name,Pageable pageable);
}
