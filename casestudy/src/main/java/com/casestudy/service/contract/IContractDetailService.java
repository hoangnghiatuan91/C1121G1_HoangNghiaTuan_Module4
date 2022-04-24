package com.casestudy.service.contract;

import com.casestudy.model.contract.ContractDetail;
import com.casestudy.service.employee.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractDetailService extends IGeneralService<ContractDetail> {
    Page<ContractDetail> findAll (Pageable pageable);
}
