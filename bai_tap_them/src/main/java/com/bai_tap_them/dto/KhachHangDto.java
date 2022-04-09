package com.bai_tap_them.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class KhachHangDto {
    private Integer id;

    @NotNull(message = "Không được để trống bạn ơi")
    @Pattern(regexp = "^[\\p{Lu}\\p{Ll}]+( [\\p{Lu}\\p{Ll}]+)*$",message = "Nhập tên tiếng Ziệt bạn ơi")
    private String tenKhachHang;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public KhachHangDto() {

    }
}
