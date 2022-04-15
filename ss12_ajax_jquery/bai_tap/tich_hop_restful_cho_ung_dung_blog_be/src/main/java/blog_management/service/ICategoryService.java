package blog_management.service;

import blog_management.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void remove(Integer id);
}
