package com.bai_tap_test.service;

import com.bai_tap_test.model.MedicalRecord;
import com.bai_tap_test.repository.IMedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalRecordService implements IMedicalRecordService{

    @Autowired
    private IMedicalRecordRepository medicalRecordRepository;

    @Override
    public List<MedicalRecord> findAll() {
        return medicalRecordRepository.findAll();
    }

    @Override
    public Optional<MedicalRecord> findById(Long id) {
        return medicalRecordRepository.findById(id);
    }

    @Override
    public void save(MedicalRecord medicalRecord) {
    medicalRecordRepository.save(medicalRecord);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Page<MedicalRecord> findAllMedicalRecord(Pageable pageable, String code, String fromDate, String toDate) {
//        return medicalRecordRepository.findAllMedicalRecord(pageable,fromDate,toDate,code);
        return medicalRecordRepository.findAllByDeleteFlagAndStartDateBetweenAndMedicalRecordCodeContaining(pageable,false,fromDate,toDate,code);
    }

    @Override
    public MedicalRecord findByMedicalRecordCode(String code) {
        return medicalRecordRepository.findByMedicalRecordCode(code);
    }
}
