package com.example.quanlydienthoai.repository;

import com.example.quanlydienthoai.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartphoneRepository extends JpaRepository<Smartphone,Long> {
}
