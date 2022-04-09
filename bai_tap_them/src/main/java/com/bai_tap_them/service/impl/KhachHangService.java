package com.bai_tap_them.service.impl;

import com.bai_tap_them.model.KhachHang;
import com.bai_tap_them.repository.IKhachHangRepository;
import com.bai_tap_them.service.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService implements IKhachHangService {
    @Autowired
    private IKhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> findAll() {
        return this.khachHangRepository.findAll();
    }

    @Override
    public KhachHang findById(Integer id) {
        return this.khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public void save(KhachHang khachHang) {
        this.khachHangRepository.save(khachHang);
    }

    @Override
    public void remove(Integer id) {
        this.khachHangRepository.deleteById(id);
    }
}
