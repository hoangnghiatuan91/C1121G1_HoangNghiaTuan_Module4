package com.casestudy.service.impl.customer;

import com.casestudy.model.customer.Customer;
import com.casestudy.repository.customer.ICustomerRepository;
import com.casestudy.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable, String customer_name) {
        return customerRepository.findAllByCustomerNameContaining(pageable, customer_name);
    }

    @Override
    public Page<Customer> findCustomer(Pageable pageable, String customer_name) {
        return customerRepository.findCustomer(pageable,customer_name);
    }

    @Override
    public Customer findByCode(String customerCode) {
        return customerRepository.findByCustomerCode(customerCode);
    }
}
