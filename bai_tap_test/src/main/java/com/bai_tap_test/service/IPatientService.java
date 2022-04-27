package com.bai_tap_test.service;

import com.bai_tap_test.model.Patient;

public interface IPatientService extends IGeneralService<Patient>{
    Patient findByPatientCode(String code);
}
