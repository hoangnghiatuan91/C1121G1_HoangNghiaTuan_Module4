package com.bai_tap_them.model;

import javax.persistence.*;

@Entity
public class SoTietKiem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "date")
    private String thoiGianGui;
    private Integer kyHan;
    private Long soTienGui;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang", referencedColumnName = "id")
    private KhachHang khachHang;

    public Integer getId() {
        return id;
    }

    public void setId(Integer idSo) {
        this.id = idSo;
    }

    public String getThoiGianGui() {
        return thoiGianGui;
    }

    public void setThoiGianGui(String thoiGianGui) {
        this.thoiGianGui = thoiGianGui;
    }

    public Integer getKyHan() {
        return kyHan;
    }

    public void setKyHan(Integer kyHan) {
        this.kyHan = kyHan;
    }

    public Long getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(Long soTienGui) {
        this.soTienGui = soTienGui;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}
