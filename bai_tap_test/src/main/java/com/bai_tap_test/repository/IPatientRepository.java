package com.bai_tap_test.repository;

import com.bai_tap_test.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient,Long> {
    Patient findByPatientCode(String code);
}
