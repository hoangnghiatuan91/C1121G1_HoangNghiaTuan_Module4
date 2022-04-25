//package com.casestudy.model.customer;
//
//import com.casestudy.model.contract.AttachService;
//import com.casestudy.model.contract.Contract;
//import com.casestudy.model.contract.ContractDetail;
//import com.casestudy.model.service.Services;
//
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "customer_using_service")
//public class CustomerUsingService {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @One
//    private Customer customer;
//    private Contract contract;
//    private Services services;
//    private ContractDetail contractDetail;
//    private AttachService attachService;
//
//    public CustomerUsingService() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public Contract getContract() {
//        return contract;
//    }
//
//    public void setContract(Contract contract) {
//        this.contract = contract;
//    }
//
//    public Services getServices() {
//        return services;
//    }
//
//    public void setServices(Services services) {
//        this.services = services;
//    }
//
//    public ContractDetail getContractDetail() {
//        return contractDetail;
//    }
//
//    public void setContractDetail(ContractDetail contractDetail) {
//        this.contractDetail = contractDetail;
//    }
//
//    public AttachService getAttachService() {
//        return attachService;
//    }
//
//    public void setAttachService(AttachService attachService) {
//        this.attachService = attachService;
//    }
//}
