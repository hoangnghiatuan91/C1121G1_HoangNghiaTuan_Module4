package com.casestudy.dto;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.employee.Employee;
import com.casestudy.model.service.Services;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContractDto implements Validator {
    private Long contractId;

    @NotBlank(message = "Can not be blank")
    @Pattern(regexp = "^(^$|(?:19\\d{2}|20\\d{2})[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])$)",
            message = "Correct format: dd/MM/yyyy")
    private String contractStartDate;

    @NotBlank(message = "Can not be blank")
    @Pattern(regexp = "^(^$|(?:19\\d{2}|20\\d{2})[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])$)",
            message = "Correct format: dd/MM/yyyy")
    private String contractEndDate;

    @NotNull(message = "Can not be blank")
    @Min(value = 1, message = "Must greater than 0")
    private Double contractDeposit;

    @NotNull(message = "Can not be blank")
    @Min(value = 1, message = "Must greater than 0")
    private Double contractTotalMoney;

    private boolean deleteFlag;


    private Employee employee;

    private Customer customer;

    private Services services;

    public ContractDto() {
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        final String REGEX_DATE = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";
        ContractDto contractDto = (ContractDto) target;
        if (!contractDto.getContractEndDate().matches(REGEX_DATE)){
            errors.rejectValue("contractEndDate","","invalid date");
        }
        if (!contractDto.getContractStartDate().matches(REGEX_DATE)){
            errors.rejectValue("contractStartDate","","invalid date");
        }
        if(contractDto.getContractStartDate().matches(REGEX_DATE)&&contractDto.getContractEndDate().matches(REGEX_DATE)){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDay = LocalDate.parse(contractDto.getContractStartDate(),dateTimeFormatter);
            LocalDate endDay = LocalDate.parse(contractDto.getContractEndDate(),dateTimeFormatter);
            if(startDay.isAfter(endDay)){
                errors.rejectValue("contractEndDate","","End date must be after start date");
            }
        }

    }
}
