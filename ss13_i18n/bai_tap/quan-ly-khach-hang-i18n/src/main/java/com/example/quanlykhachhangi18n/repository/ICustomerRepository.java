package com.example.quanlykhachhangi18n.repository;

import com.example.quanlykhachhangi18n.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
}
