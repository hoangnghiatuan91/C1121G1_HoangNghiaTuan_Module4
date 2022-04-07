package com.validateformdangky.service;

import com.validateformdangky.model.RegistrationForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRegistrationFormService {
    Page<RegistrationForm> findAll(Pageable pageable);

    void save(RegistrationForm registrationForm);
}
