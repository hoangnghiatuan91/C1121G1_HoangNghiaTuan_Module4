package com.casestudy.dto;

import com.casestudy.model.service.RentType;
import com.casestudy.model.service.ServiceType;
import com.casestudy.model.service.Services;
import com.casestudy.service.service.IServicesService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class ServicesDto implements Validator {
    private Long serviceId;

    @NotBlank(message = "Can not be null")
    @Pattern(regexp = "^(^$|(DV-)(\\d{4}))$", message = "Correct format: DV-XXXX.")
    private String serviceCode;

    @NotBlank(message = "Can not be null")
    private String serviceName;

    @Min(value = 1, message = "Must be greater than 0")
    private Integer serviceArea;

    @NotNull(message = "Can not be null")
    @Min(value = 1, message = "Must be greater than 0")
    private Double serviceCost;

    @Min(value = 1, message = "Must be greater than 0")
    private Integer serviceMaxPeople;

    private String standardRoom;

    private String descriptionOtherConvenience;

    private Double poolArea;

    private Integer numberOfFloors;

    private String complimentaryIncludedService;

    private RentType rentType;

    private ServiceType serviceType;

    private IServicesService servicesService;

    public ServicesDto() {
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getComplimentaryIncludedService() {
        return complimentaryIncludedService;
    }

    public void setComplimentaryIncludedService(String complimentaryIncludedService) {
        this.complimentaryIncludedService = complimentaryIncludedService;
    }

    public IServicesService getServicesService() {
        return servicesService;
    }

    public void setServicesService(IServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
final String regexNumber = "^\\d+$";
//        final String regexPoolArea = "^([0]*[1-9][0-9]*)|[1-9][0-9]*$";
//        final String regexRoomStandard = "^$|[A-Za-z]+";
        ServicesDto servicesDto = (ServicesDto) target;
        String currentServiceCode = servicesDto.getServiceCode();
//        if(!(servicesDto.getServiceType().getServiceTypeId()==3)){
//            errors.rejectValue("numberOfFloors","","Must be greater than 0");
//        }
        Services services = this.servicesService.findByCode(currentServiceCode);
        if(services!=null){
            if(services.getServiceCode().equals(currentServiceCode)){
                errors.rejectValue("serviceCode","","Code is already existed");
            }
        }
    }
}
