package blog.service;

import blog.model.Blog;
import blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findByName(String searchName) {
        return blogRepository.findBlogsByNameContaining(searchName);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);

    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }


    @Override
    public void remove(Blog blog) {
        blogRepository.delete(blog);
    }
}
