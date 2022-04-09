package com.bai_tap_them.service.impl;

import com.bai_tap_them.model.SoTietKiem;
import com.bai_tap_them.repository.ISoTietKiemRepository;
import com.bai_tap_them.service.ISoTietKiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SoTietKiemService implements ISoTietKiemService {

    @Autowired
    private ISoTietKiemRepository soTietKiemRepository;

    @Override
    public Page<SoTietKiem> findAll(String name, Pageable pageable) {
        return soTietKiemRepository.findAllByKhachHang_TenKhachHangContaining(name, pageable);
    }

    @Override
    public SoTietKiem findById(Integer id) {
        return soTietKiemRepository.findById(id).orElse(null);
    }

    @Override
    public void save(SoTietKiem soTietKiem) {
        soTietKiemRepository.save(soTietKiem);
    }

    @Override
    public void remove(Integer id) {
        soTietKiemRepository.deleteById(id);
    }
}
