package com.casestudy.service.customer;

import com.casestudy.model.customer.Customer;
import com.casestudy.service.employee.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findAll (Pageable pageable, String customer_name);
    Page<Customer> findCustomer(Pageable pageable, String customer_name);
    Customer findByCode(String customerCode);
    Page<ICustomerUseService> findAllCustomerUseServicePage(Pageable pageable);
    List<Customer> findAllCustomer();
}
