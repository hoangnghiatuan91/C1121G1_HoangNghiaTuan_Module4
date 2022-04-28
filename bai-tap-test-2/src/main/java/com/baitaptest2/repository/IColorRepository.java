package com.baitaptest2.repository;

import com.baitaptest2.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IColorRepository extends JpaRepository<Color,Long> {
}
