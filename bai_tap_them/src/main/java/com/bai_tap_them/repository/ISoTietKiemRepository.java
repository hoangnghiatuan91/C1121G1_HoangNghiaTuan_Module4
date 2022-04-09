package com.bai_tap_them.repository;

import com.bai_tap_them.model.SoTietKiem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoTietKiemRepository extends JpaRepository<SoTietKiem,Integer> {
    Page<SoTietKiem> findAll( Pageable pageable);
    Page<SoTietKiem>findAllByKhachHang_TenKhachHangContaining(String name,Pageable pageable);
//    String name,
}
