package backend.repository;

import backend.model.Blog;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
public class BlogRepositoryIMPL implements IBlogRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Blog> findAll() {
        String QR_FIND_ALL = "select st from Blog as st";
        TypedQuery<Blog> query = em.createQuery(QR_FIND_ALL, Blog.class);
        return query.getResultList();
    }

    @Override
    public List<Blog> findByName(String title) {
        String QR_FIND_BY_NAME = "select st from Blog as st where title like :title";
        TypedQuery<Blog> query = em.createQuery(QR_FIND_BY_NAME, Blog.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() != null) {
            em.merge(blog);
        } else {
            em.persist(blog);
        }
    }

    @Override
    public Blog findById(Long id) {
        String QR_FIND_BY_ID = "select st from Blog  as st where st.id = :id";
        TypedQuery<Blog> query = em.createQuery(QR_FIND_BY_ID, Blog.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void deleteById(Long id) {
        Blog blog = findById(id);
        if (blog != null) {
            em.remove(blog);
        }
    }
}
