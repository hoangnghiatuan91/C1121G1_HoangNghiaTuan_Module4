package com.casestudy.repository.customer;

import com.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
//@Query(value = "select c from Customer c where c.deleteFlag = false and c.customerName like concat('%',:customer_name,'%') ")
@Query(value = "select * from customer where customer.delete_flag = 0 and customer.customer_name like concat('%',:customer_name,'%') ",nativeQuery = true)
    Page<Customer> findAllByCustomerNameContaining (Pageable pageable, @Param("customer_name") String customer_name);

}
