package backend.repository;


import backend.model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();

    List<Blog> findByName(String name);

    void save(Blog blog);

    Blog findById(Long id);

    void deleteById(Long id);
}
