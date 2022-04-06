package customer_management.repository;

import customer_management.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByAuthorContainingOrderByCreateTime(String name, Pageable pageable);
//    Page<Blog> findCustomerByProvince(String name, Pageable pageable);
}
