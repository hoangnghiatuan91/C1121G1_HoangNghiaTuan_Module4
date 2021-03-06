package blog_management.repository;

import blog_management.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByContentContainingOrderByCreateTime(String name, Pageable pageable);
//    Page<Blog> findCustomerByProvince(String name, Pageable pageable);
}
