package com.bai_tap_test.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String patientCode;
    @Column(columnDefinition = "text")
    private String patientName;
    @OneToOne(mappedBy = "patient")
    private MedicalRecord medicalRecord;

    public Patient() {
    }
}
