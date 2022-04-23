package com.casestudy.model.contract;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.employee.Employee;
import com.casestudy.model.service.Services;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Contract {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long contractId;

        @NotNull
        @Column(columnDefinition = "datetime")
        private String contractStartDate;

        @NotNull
        @Column(columnDefinition = "datetime")
        private String contractEndDate;

        @NotNull
        private Double contractDeposit;

        @NotNull
        private Double contractTotalMoney;

        private boolean deleteFlag;

        @NotNull
        @ManyToOne
        @JoinColumn(name = "employee_id",referencedColumnName = "employeeId")
        private Employee employee;

        @NotNull
        @ManyToOne
        @JoinColumn(name = "customer_id",referencedColumnName = "customerId")
        private Customer customer;

        @NotNull
        @ManyToOne
        @JoinColumn(name = "service_id",referencedColumnName = "serviceId")
        private Services services;

        @OneToMany(mappedBy = "contract")
        private Set<ContractDetail> contractDetails;

        public Contract() {
                setDeleteFlag(false);
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

        public Set<ContractDetail> getContractDetails() {
                return contractDetails;
        }

        public void setContractDetails(Set<ContractDetail> contractDetails) {
                this.contractDetails = contractDetails;
        }
}
