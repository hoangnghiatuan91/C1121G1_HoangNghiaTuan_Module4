package com.baitaptest2.repository;

import com.baitaptest2.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findAllByDeleteFlagAndProductNameContainingAndPriceContainingAndCategory_CategoryNameContainingAndColor_ColorNameContaining(boolean deleteFlag, String name, String price, String category, String color, Pageable pageable);
    Page<Product> findAllByDeleteFlagAndProductNameContainingAndPriceContainingAndAndCategory_CategoryNameAndColor_ColorName(boolean deleteFlag, String name, Double price, String category, String color, Pageable pageable);
    @Query(value = "select * from product " +
            "            inner join category on product.category_id = category.category_id " +
            "            inner join color on product.color_id = color.color_id " +
            "            where product.delete_flag = 0 and product.product_name like concat('%',:product_name,'%') and product.price like concat('%',:product_price,'%') " +
            "            and category.category_name like concat('%',:category_name,'%') and color.color_name like concat('%',:product_color,'%') ",
            countQuery = "select count(*) from product"+
                    "            inner join category on product.category_id = category.category_id " +
                    "            inner join color on product.color_id = color.color_id " +
                    "            where product.delete_flag = 0 and product.product_name like concat('%',:product_name,'%') and product.price like concat('%',:product_price,'%') " +
                    "            and category.category_name like concat('%',:category_name,'%') and color.color_name like concat('%',:product_color,'%') ",
            nativeQuery = true)
    Page<Product> findAllBySearchValue(@Param("product_name") String productName, @Param("product_price") String productPrice, @Param("category_name") String categoryName, @Param("product_color") String productColor, Pageable pageable);
}
