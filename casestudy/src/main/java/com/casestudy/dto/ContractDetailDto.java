package com.casestudy.dto;

import com.casestudy.model.contract.AttachService;
import com.casestudy.model.contract.Contract;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ContractDetailDto {

    private Long contractDetailId;

    @NotNull
    private AttachService attachService;

    @NotNull
    private Contract contract;

    @NotBlank(message = "Can not be null")
    @Min(value = 1)
    @Pattern(regexp = "^(^$|\\d+)$",message = "Must be greater than 0")
    private String quantity;

    public ContractDetailDto() {
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
