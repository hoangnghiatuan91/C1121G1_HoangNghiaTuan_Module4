package com.bai_tap_test.service;

import com.bai_tap_test.model.Patient;
import com.bai_tap_test.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {

    @Autowired
    private IPatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Patient findByPatientCode(String code) {
        return patientRepository.findByPatientCode(code);
    }
}
