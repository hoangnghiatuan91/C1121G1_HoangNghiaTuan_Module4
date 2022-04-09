package com.bai_tap_them.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenKhachHang;
    @OneToMany(mappedBy = "khachHang")
    List<SoTietKiem> soTietKiems;

    public KhachHang() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idKhachHang) {
        this.id = idKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public List<SoTietKiem> getSoTietKiems() {
        return soTietKiems;
    }

    public void setSoTietKiems(List<SoTietKiem> soTietKiems) {
        this.soTietKiems = soTietKiems;
    }
}
