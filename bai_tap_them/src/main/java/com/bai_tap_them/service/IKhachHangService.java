package com.bai_tap_them.service;

import com.bai_tap_them.model.KhachHang;

import java.util.List;

public interface IKhachHangService {
    List<KhachHang> findAll();

    KhachHang findById(Integer id);

    void save(KhachHang khachHang);

    void remove(Integer id);
}
