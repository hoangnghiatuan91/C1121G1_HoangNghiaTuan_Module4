package com.baitaptest2.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Setter
@Getter
public class Category {
    @Id
    private Long categoryId;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    Set<Product> products;

    public Category() {
    }
}
