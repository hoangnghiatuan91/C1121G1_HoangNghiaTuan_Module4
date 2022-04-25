package com.casestudy.repository.contract;

import com.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract,Long> {
    Page<Contract> findAllByDeleteFlag(Pageable pageable,boolean deleteFlag);


}
