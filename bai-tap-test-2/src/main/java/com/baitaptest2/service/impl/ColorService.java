package com.baitaptest2.service.impl;

import com.baitaptest2.model.Color;
import com.baitaptest2.repository.IColorRepository;
import com.baitaptest2.service.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService implements IColorService {

    @Autowired
    private IColorRepository colorRepository;

    @Override
    public List<Color> findAll() {
        return colorRepository.findAll();
    }

    @Override
    public Optional<Color> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Color color) {

    }

    @Override
    public void remove(Long id) {

    }
}
