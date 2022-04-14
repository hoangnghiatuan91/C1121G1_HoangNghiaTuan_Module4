package com.example.quanlykhachhang.repository;

import com.example.quanlykhachhang.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}
