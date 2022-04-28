package com.baitaptest2.dto;

import com.baitaptest2.model.Category;
import com.baitaptest2.model.Color;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDto {
    private Long productId;
    @NotBlank(message = "Can not be null")
    private String productName;
    @NotNull(message = "Can not be null")
    @Min(value = 10000000)
    private Double price;
    @NotNull(message = "Can not be null")
    @Min(value = 0,message = "Must be greater than 0")
    private Long quantity;
    private boolean deleteFlag;
    private Category category;
    private Color color;

    public ProductDto() {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
