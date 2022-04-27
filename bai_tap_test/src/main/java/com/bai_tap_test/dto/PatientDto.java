package com.bai_tap_test.dto;

import com.bai_tap_test.model.MedicalRecord;
import com.bai_tap_test.model.Patient;
import com.bai_tap_test.service.IPatientService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class PatientDto implements Validator {

    private Long patientId;

    @NotBlank(message = "Can not be null")
    @Pattern(regexp = "^(^$|(BN-)(\\d{4}))$", message = "Correct format: BN-XXXX.")
    private String patientCode;

    @NotBlank(message = "Can not be null")
    @Pattern(regexp = "(^$|^[\\p{Lu}\\p{Ll}]+( [\\p{Lu}\\p{Ll}]+)*$)", message = "Not correct format")
    private String patientName;

    private IPatientService patientService;

    public PatientDto() {
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public IPatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(IPatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
PatientDto patientDto = (PatientDto) target;
        String currentCode = patientDto.getPatientCode();
        Patient patient = patientService.findByPatientCode(currentCode);
        if(patient!=null){
            if(patient.getPatientCode().equals(currentCode)){
                errors.rejectValue("patientCode","","Trùng rồi em ei");
            }
        }
    }
}
