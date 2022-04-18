package com.example.quanlykhachhangi18n.service;

import com.example.quanlykhachhangi18n.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
}
