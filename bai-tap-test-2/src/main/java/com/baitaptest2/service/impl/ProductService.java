package com.baitaptest2.service.impl;

import com.baitaptest2.model.Product;
import com.baitaptest2.repository.IProductRepository;
import com.baitaptest2.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Page<Product> findAllProduct(String name, String price, String category, String color, Pageable pageable) {
//        return productRepository.findAllByDeleteFlagAndProductNameContainingAndPriceContainingAndCategory_CategoryNameContainingAndColor_ColorNameContaining(false,name,price,category,color,pageable);
//        return productRepository.findAllByDeleteFlagAndProductNameContainingAndPriceContainingAndAndCategory_CategoryNameAndColor_ColorName(false,name,price,category,color,pageable);
        return productRepository.findAllBySearchValue(name,price,category,color,pageable);
    }
}
