package com.example.quanlykhachhangi18n.service.impl;

import com.example.quanlykhachhangi18n.model.Customer;
import com.example.quanlykhachhangi18n.repository.ICustomerRepository;
import com.example.quanlykhachhangi18n.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
