package com.casestudy.service.impl.employee;

import com.casestudy.model.employee.EducationDegree;
import com.casestudy.repository.employee.IEducationDegreeRepository;
import com.casestudy.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationDegreeService implements IEducationDegreeService {

    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public Optional<EducationDegree> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(EducationDegree educationDegree) {

    }

    @Override
    public void remove(Long id) {

    }
}
