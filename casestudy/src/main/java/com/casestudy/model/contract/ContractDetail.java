package com.casestudy.model.contract;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractDetailId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "attach_service_id",referencedColumnName = "attachServiceId")
    private AttachService attachService;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "contract_id",referencedColumnName = "contractId")
    private Contract contract;

    @NotNull
    private String quantity;

    public ContractDetail() {
    }

    public Long getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Long contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
