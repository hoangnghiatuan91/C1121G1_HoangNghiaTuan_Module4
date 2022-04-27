package com.bai_tap_test.service;

import com.bai_tap_test.model.MedicalRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMedicalRecordService extends IGeneralService<MedicalRecord>{
    Page<MedicalRecord> findAllMedicalRecord(Pageable pageable,String code,String fromDate,String toDate);
    MedicalRecord findByMedicalRecordCode(String code);
}
