package com.casestudy.service.employee;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T>{
    List<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
}
