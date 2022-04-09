package com.bai_tap_them.service;

import com.bai_tap_them.model.SoTietKiem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISoTietKiemService {
    Page<SoTietKiem> findAll(String name, Pageable pageable);

    SoTietKiem findById(Integer id);

    void save(SoTietKiem soTietKiem);

    void remove(Integer id);
}
