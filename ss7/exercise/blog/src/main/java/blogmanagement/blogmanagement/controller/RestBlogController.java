package blogmanagement.blogmanagement.controller;

import blogmanagement.blogmanagement.model.Blog;
import blogmanagement.blogmanagement.model.Category;
import blogmanagement.blogmanagement.service.IBlogService;
import blogmanagement.blogmanagement.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog/v1")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<List<Blog>> getBlogList() {
        List<Blog> blogList = blogService.findAllBlog();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<List<Blog>> blogOfCategory(@RequestBody int idCategory){
        Category category = categoryService.findById(idCategory);
        if(category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Blog> blogList = blogService.findByCategory(category);
        if(blogList == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @GetMapping("/detail")
    public ResponseEntity<Blog> blogDetail(@RequestBody int idBlog){
        Blog blog = blogService.findById(idBlog);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

}
