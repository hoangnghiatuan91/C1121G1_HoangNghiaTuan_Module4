package com.bai_tap_test.dto;

import com.bai_tap_test.model.MedicalRecord;
import com.bai_tap_test.model.Patient;
import com.bai_tap_test.service.IMedicalRecordService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MedicalRecordDto implements Validator {
    private Long medicalRecordId;
    @NotBlank
    @Pattern(regexp = "^(^$|(BA-)(\\d{4}))$", message = "Correct format: BA-XXXX.")
    private String medicalRecordCode;
    @NotBlank
    @Pattern(regexp = "^(^$|(?:19\\d{2}|20\\d{2})[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])$)",
            message = "Correct format: dd/MM/yyyy.")
    private String startDate;

    @NotBlank
    @Pattern(regexp = "^(^$|(?:19\\d{2}|20\\d{2})[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])$)",
            message = "Correct format: dd/MM/yyyy.")
    private String endDate;

    @NotBlank
    private String reason;
    private boolean deleteFlag;
    private IMedicalRecordService medicalRecordService;

//    @Valid
    private PatientDto patientDto;

    public MedicalRecordDto() {
    }

    public Long getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(Long medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public String getMedicalRecordCode() {
        return medicalRecordCode;
    }

    public void setMedicalRecordCode(String medicalRecordCode) {
        this.medicalRecordCode = medicalRecordCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public IMedicalRecordService getMedicalRecordService() {
        return medicalRecordService;
    }

    public void setMedicalRecordService(IMedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    public PatientDto getPatientDto() {
        return patientDto;
    }

    public void setPatientDto(PatientDto patientDto) {
        this.patientDto = patientDto;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        final String REGEX_DATE = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";
        MedicalRecordDto medicalRecordDto = (MedicalRecordDto) target;
        if(medicalRecordDto.getMedicalRecordId()==null){
            String currentCode = medicalRecordDto.getMedicalRecordCode();
            MedicalRecord medicalRecord = medicalRecordService.findByMedicalRecordCode(currentCode);
            if(medicalRecord!=null){
                if(medicalRecord.getMedicalRecordCode().equals(currentCode)){
                    errors.rejectValue("medicalRecordCode","","Trùng rồi em ei");
                }
            }
        }
        if (!medicalRecordDto.getStartDate().matches(REGEX_DATE)){
            errors.rejectValue("startDate","","invalid date");
        }
        if (!medicalRecordDto.getEndDate().matches(REGEX_DATE)){
            errors.rejectValue("endDate","","invalid date");
        }
        if(medicalRecordDto.getStartDate().matches(REGEX_DATE)&&medicalRecordDto.getEndDate().matches(REGEX_DATE)){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDay = LocalDate.parse(medicalRecordDto.getStartDate(),dateTimeFormatter);
            LocalDate endDay = LocalDate.parse(medicalRecordDto.getEndDate(),dateTimeFormatter);
            if(startDay.isAfter(endDay)){
                errors.rejectValue("endDate","","End date must be after start date");
            }
        }

    }
}
