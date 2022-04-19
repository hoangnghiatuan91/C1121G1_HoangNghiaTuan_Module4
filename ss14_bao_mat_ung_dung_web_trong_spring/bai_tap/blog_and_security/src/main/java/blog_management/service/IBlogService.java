package blog_management.service;

import blog_management.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll(String name, Pageable pageable);

    Blog findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

//    Page<Customer> findAllByFirstNameContaining(String name,Pageable pageable);
}
