package blog_management.controller;

import blog_management.model.Blog;
import blog_management.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class BlogRestController {


    @Autowired
    private IBlogService blogService;

    @GetMapping("/blogRest")
    public ResponseEntity<Page<Blog>> listBlogs(@PageableDefault(value = 2) Pageable pageable,
                                    @RequestParam(name = "searchName") Optional<String> searchName) {
        String searchNameValue = searchName.orElse("");
        Page<Blog> blogs = blogService.findAll(searchNameValue,pageable);
        return new ResponseEntity<>(blogs, HttpStatus.OK);

    }

    @GetMapping("/listRest")
    public ResponseEntity<Page<Blog>> showBlog(@RequestParam int page,
                                               @RequestParam(name = "searchName") Optional<String> searchName){
        String searchNameValue = searchName.orElse("");
        Page<Blog> blogList = this.blogService.findAll(searchNameValue ,PageRequest.of(page,1));
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    @PostMapping("/create-blogRest")
    public ResponseEntity<Void> saveBlog(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/view-blogRest/{id}")
    public ResponseEntity<Blog> view(@PathVariable Integer id) {
        Blog blog = blogService.findById(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

    @GetMapping("/blogRestByCategory")
    public ResponseEntity<List<Blog>> listBlogsByCategory(@RequestParam(name = "searchName") String searchName) {
        List<Blog> blogs = blogService.findAllByCategoryName(searchName);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
