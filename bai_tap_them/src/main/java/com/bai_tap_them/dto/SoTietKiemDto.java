package com.bai_tap_them.dto;

import com.bai_tap_them.model.KhachHang;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SoTietKiemDto {

    private Integer id;
    @NotBlank(message = "Không được để trống")
    private String thoiGianGui;
    @NotNull(message = "Không được để trống")
    private Integer kyHan;
    @NotNull
    @Min(value = 30000000,message = "Số tiền ít nhất 30.000.000")
    private Long soTienGui;
    private KhachHang khachHang;

    public SoTietKiemDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
