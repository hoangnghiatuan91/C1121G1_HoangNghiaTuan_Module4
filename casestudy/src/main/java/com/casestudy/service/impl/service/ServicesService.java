package com.casestudy.service.impl.service;

import com.casestudy.model.service.Services;
import com.casestudy.repository.service.IServicesRepository;
import com.casestudy.service.service.IServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesService implements IServicesService {

    @Autowired
    private IServicesRepository servicesRepository;

    @Override
    public List<Services> findAll() {
        return servicesRepository.findAll();
    }

    @Override
    public Optional<Services> findById(Long id) {
        return servicesRepository.findById(id);
    }

    @Override
    public void save(Services services) {
        servicesRepository.save(services);
    }

    @Override
    public void remove(Long id) {
        servicesRepository.deleteById(id);
    }

    @Override
    public Page<Services> findAll(Pageable pageable, String service_name) {
        return servicesRepository.findAllByServiceNameContaining(pageable,service_name);
    }

    @Override
    public Services findByCode(String serviceCode) {
        return servicesRepository.findByServiceCode(serviceCode);
    }
}
