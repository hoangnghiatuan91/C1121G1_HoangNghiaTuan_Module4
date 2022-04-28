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
public class Color {
    @Id
    private Long colorId;
    private String colorName;

    @OneToMany(mappedBy = "color")
    private Set<Product> products;
    public Color() {
    }
}
