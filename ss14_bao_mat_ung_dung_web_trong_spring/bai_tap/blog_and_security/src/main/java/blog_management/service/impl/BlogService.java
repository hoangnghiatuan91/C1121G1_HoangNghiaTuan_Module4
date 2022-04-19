package blog_management.service.impl;

import blog_management.model.Blog;
import blog_management.repository.IBlogRepository;
import blog_management.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BlogService implements IBlogService {

    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(String name, Pageable pageable) {
        return iBlogRepository.findAllByContentContainingOrderByCreateTime(name,pageable);
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
       if(blog.getId() == null){
           blog.setCreateTime(String.valueOf(LocalDateTime.now()));
           iBlogRepository.save(blog);
       } else {
//           blog.setCreateTime(blog.getCreateTime());
           iBlogRepository.save(blog);
       }
    }

    @Override
    public void remove(Integer id) {
        iBlogRepository.deleteById(id);
    }

//    @Override
//    public Page<Customer> (String searchName,Pageable pageable) {
//        return iCustomerRepository.findAllByFirstNameContaining(searchName,pageable);
//    }
}
