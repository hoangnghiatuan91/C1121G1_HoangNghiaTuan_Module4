package com.casestudy.dto;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.customer.CustomerType;
import com.casestudy.service.customer.ICustomerService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

public class CustomerDto implements Validator {
    private Long customerId;


    @NotBlank(message = "Can not be blank")
    @Pattern(regexp = "^(^$|(KH-)(\\d{4}))$", message = "Correct format: KH-XXXX.")
    private String customerCode;

    @NotBlank(message = "Can not be blank")
    @Pattern(regexp = "^(^$|[\\p{Lu}\\p{Ll}]+( [\\p{Lu}\\p{Ll}]+)*)$",
            message = "Not correct format")
    private String customerName;

    @NotBlank(message = "Can not be blank")
    @Pattern(regexp = "^(^$|(?:19\\d{2}|20\\d{2})[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])$)",
            message = "Correct format: dd/MM/yyyy.")
    private String customerBirthday;

    private Integer customerGender;

    @NotBlank(message = "Can not be blank")
    @Pattern(regexp = "^(^$|([0-9]{9})|([0-9]{12})$)",
            message = "Correct format: XXXXXXXXX or XXXXXXXXXXXX.")
    private String customerIdCard;

    @NotBlank(message = "Can not be blank")
    @Pattern(regexp = "^(^$|(0|(\\(84\\)\\+))+([9][0-1][0-9]{7}))$",
            message = "Correct format: 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx")
    private String customerPhone;

    @NotBlank(message = "Can not be blank")
    @Pattern(regexp = "^(^$|(?:^|\\s)[\\w!#$%&'*+/=?^`{|}~-](\\.?[\\w!#$%&'*+/=?^`{|}~-]+)*@\\w+[.-]?\\w*\\.[a-zA-Z]{2,3}\\b)$",
            message = "Not correct format")
    private String customerEmail;

    private String customerAddress;

    private CustomerType customerType;

    private boolean deleteFlag;

    private ICustomerService customerService;

    public CustomerDto() {
        this.deleteFlag = false;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public ICustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        String customerCurrentCode = customerDto.getCustomerCode();
        Customer customer = this.customerService.findByCode(customerCurrentCode);
        if(customer!=null){
            if(customer.getCustomerCode().equals(customerCurrentCode)){
                errors.rejectValue("customerCode","","Code is already existed");
            }
        }
    }
}
