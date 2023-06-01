package backend.service;


import backend.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    List<Blog> findByName(String name);

    void save(Blog blog);

    Blog findById(Long id);

    void deleteById(Long id);
}
