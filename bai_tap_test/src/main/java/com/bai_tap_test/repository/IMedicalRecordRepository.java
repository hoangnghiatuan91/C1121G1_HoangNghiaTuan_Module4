package com.bai_tap_test.repository;

import com.bai_tap_test.model.MedicalRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IMedicalRecordRepository extends JpaRepository<MedicalRecord,Long> {
    @Query(value = "select * from medical_record where medical_record.delete_flag = 0 and " +
            "(medical_record.start_date between :fromDate and :toDate) " +
            "and medical_record.medical_record_code like concat('%',:code,'%')",nativeQuery = true)
    Page<MedicalRecord> findAllMedicalRecord(Pageable pageable, String fromDate, String toDate, String code);

    Page<MedicalRecord> findAllByDeleteFlagAndStartDateBetweenAndMedicalRecordCodeContaining(Pageable pageable,boolean deleteFlag, String fromDate, String toDate, String code);

    MedicalRecord findByMedicalRecordCode(String code);
}
