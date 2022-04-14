package blog_management.repository;

import blog_management.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByContentContainingOrderByCreateTimeBlog(String name, Pageable pageable);
    List<Blog> findAllByCategory_Name(String name);
//    Page<Blog> findCustomerByProvince(String name, Pageable pageable);
}
