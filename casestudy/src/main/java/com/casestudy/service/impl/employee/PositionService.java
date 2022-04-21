package com.casestudy.service.impl.employee;

import com.casestudy.model.employee.Position;
import com.casestudy.repository.employee.IPositionRepository;
import com.casestudy.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService implements IPositionService {

    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Optional<Position> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Position position) {

    }

    @Override
    public void remove(Long id) {

    }
}
