package com.casestudy.service.impl.employee;

import com.casestudy.model.employee.Division;
import com.casestudy.service.employee.IDivisionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DivisionService implements IDivisionService {
    @Override
    public List<Division> findAll() {
        return null;
    }

    @Override
    public Optional<Division> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Division division) {

    }

    @Override
    public void remove(Long id) {

    }
}
