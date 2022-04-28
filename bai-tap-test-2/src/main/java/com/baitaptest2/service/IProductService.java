package com.baitaptest2.service;

import com.baitaptest2.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGeneralService<Product> {
    Page<Product> findAllProduct( String name, String price, String category, String color, Pageable pageable);
}
