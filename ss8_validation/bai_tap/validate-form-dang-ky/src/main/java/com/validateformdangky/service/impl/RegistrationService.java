package com.validateformdangky.service.impl;

import com.validateformdangky.model.RegistrationForm;
import com.validateformdangky.repository.IRegistrationFormRepository;
import com.validateformdangky.service.IRegistrationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService implements IRegistrationFormService {
    @Autowired
    private IRegistrationFormRepository registrationFormRepository;

    @Override
    public Page<RegistrationForm> findAll(Pageable pageable) {
        return this.registrationFormRepository.findAll(pageable);
    }

    @Override
    public void save(RegistrationForm registrationForm) {
        this.registrationFormRepository.save(registrationForm);
    }
}
