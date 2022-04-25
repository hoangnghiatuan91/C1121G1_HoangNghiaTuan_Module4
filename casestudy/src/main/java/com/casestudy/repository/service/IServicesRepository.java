package com.casestudy.repository.service;

import com.casestudy.model.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IServicesRepository extends JpaRepository<Services,Long> {
    Page<Services> findAllByServiceNameContaining (Pageable pageable, String service_name);
    Services findByServiceCode(String serviceCode);
}
