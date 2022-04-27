package com.bai_tap_test.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MedicalRecord {
    @Id
    @GeneratedValue
    private Long medicalRecordId;
    private String medicalRecordCode;
    private String startDate;

    private String endDate;
    @Column(columnDefinition = "text")
    private String reason;
    private boolean deleteFlag;
    @OneToOne()
    @JoinColumn(name = "patient_id",referencedColumnName = "patientId")
    private Patient patient;

    public MedicalRecord() {
        setDeleteFlag(false);
    }
}
