package com.casestudy.service.impl.contract;

import com.casestudy.model.contract.ContractDetail;
import com.casestudy.repository.contract.IContractDetailRepository;
import com.casestudy.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAllContractDetail(pageable);
    }

    @Override
    public List<ContractDetail> findAll() {
        return null;
    }

    @Override
    public Optional<ContractDetail> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(Long id) {

    }
}
