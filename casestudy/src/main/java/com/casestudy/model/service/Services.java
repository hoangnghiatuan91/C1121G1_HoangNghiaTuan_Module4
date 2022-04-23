package com.casestudy.model.service;

import com.casestudy.model.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    private String serviceCode;

    private String serviceName;

    private Integer serviceArea;

    private Double serviceCost;

    private Integer serviceMaxPeople;

    private String standardRoom;

    private String descriptionOtherConvenience;

    private Double poolArea;

    private Integer numberOfFloors;

    private String complimentaryIncludedService;

    @ManyToOne(targetEntity =  ServiceType.class)
    @JoinColumn(name = "service_type_id",referencedColumnName = "serviceTypeId")
    private ServiceType serviceType;

    @ManyToOne(targetEntity = RentType.class)
    @JoinColumn(name = "rent_type_id", referencedColumnName = "rentTypeId")
    private RentType rentType;

    @OneToMany(mappedBy = "services")
    private Set<Contract> contracts;

    public Services() {
    }

    public Services(String serviceCode, String serviceName, Integer serviceArea, Double serviceCost, Integer serviceMaxPeople, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors,String complimentaryIncludedService) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.complimentaryIncludedService = complimentaryIncludedService;
    }

    public Services(Long serviceId, String serviceCode, String serviceName, Integer serviceArea, Double serviceCost, Integer serviceMaxPeople, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors,String complimentaryIncludedService) {
        this.serviceId = serviceId;
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.complimentaryIncludedService = complimentaryIncludedService;
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

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public String getComplimentaryIncludedService() {
        return complimentaryIncludedService;
    }

    public void setComplimentaryIncludedService(String complimentaryIncludedService) {
        this.complimentaryIncludedService = complimentaryIncludedService;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
