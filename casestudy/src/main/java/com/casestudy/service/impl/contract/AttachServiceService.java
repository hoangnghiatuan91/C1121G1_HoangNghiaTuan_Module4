package com.casestudy.service.impl.contract;

import com.casestudy.model.contract.AttachService;
import com.casestudy.repository.contract.IAttachServiceRepository;
import com.casestudy.service.contract.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachServiceService implements IAttachServiceService {

    @Autowired
    private IAttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public Optional<AttachService> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(AttachService attachService) {

    }

    @Override
    public void remove(Long id) {

    }
}
