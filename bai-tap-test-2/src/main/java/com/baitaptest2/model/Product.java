package com.baitaptest2.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private Double price;
    private Long quantity;
    private boolean deleteFlag;

    @ManyToOne()
    @JoinColumn(name = "category_id",referencedColumnName = "categoryId")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "color_id",referencedColumnName = "colorId")
    private Color color;
    public Product() {
        setDeleteFlag(false);
    }

}
