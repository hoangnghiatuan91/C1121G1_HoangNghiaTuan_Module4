package com.casestudy.repository.contract;

import com.casestudy.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Long> {
    @Query(value = "select * from contract_detail",nativeQuery = true)
    Page<ContractDetail> findAllContractDetail (Pageable pageable);
}
