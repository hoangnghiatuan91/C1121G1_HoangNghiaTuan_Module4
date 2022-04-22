package com.casestudy.repository.service;

import com.casestudy.model.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType,Long> {
}
