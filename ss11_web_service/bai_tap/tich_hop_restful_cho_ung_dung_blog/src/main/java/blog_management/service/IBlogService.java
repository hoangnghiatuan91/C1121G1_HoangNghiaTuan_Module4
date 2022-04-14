package blog_management.service;

import blog_management.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(String name, Pageable pageable);

    Blog findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

    List<Blog> findAllByCategoryName(String name);

//    Page<Customer> findAllByFirstNameContaining(String name,Pageable pageable);
}
