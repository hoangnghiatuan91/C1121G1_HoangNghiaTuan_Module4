package com.validateformdangky.repository;

import com.validateformdangky.model.RegistrationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegistrationFormRepository extends JpaRepository<RegistrationForm,Integer> {
}
