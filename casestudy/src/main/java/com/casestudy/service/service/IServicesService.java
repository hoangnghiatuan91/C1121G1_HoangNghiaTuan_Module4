package com.casestudy.service.service;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.service.Services;
import com.casestudy.service.employee.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServicesService extends IGeneralService<Services> {
    Page<Services> findAll (Pageable pageable, String service_name);
}
