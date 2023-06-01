package backend.service;

import backend.model.Blog;
import backend.repository.IBlogRepository;
import backend.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceIMPL implements IBlogService {
    @Autowired
    private IBlogRepository bLogRepository;

    @Override
    public List<Blog> findAll() {
        return bLogRepository.findAll();
    }

    @Override
    public List<Blog> findByName(String name) {
        return bLogRepository.findByName(name);
    }

    @Override
    public void save(Blog blog) {
        bLogRepository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return bLogRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        bLogRepository.deleteById(id);
    }
}
