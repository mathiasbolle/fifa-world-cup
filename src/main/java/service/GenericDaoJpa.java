package service;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
public class GenericDaoJpa<T> implements GenericDao<T> {
    private Class<T> type;
    protected EntityManager em;

    public GenericDaoJpa(Class<T> type) {
        super();
        this.type = type;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional(readOnly = true)
    public List<T> findAll() {
        return this.em.createQuery("select entity from " + this.type.getName() + " entity").getResultList();
    }

    @Override
    public T update(T object) {
        return em.merge(object);
    }

    @Override
    public T get(Long id) {
        return this.em.find(this.type, id);
    }

    @Override
    public void delete(T object) {
        em.remove(em.merge(object));
    }

    @Override
    public void insert(T object) {
        em.persist(object);
    }

    @Override
    public boolean exists(Long id) {
        return this.em.find(this.type, id) != null;
    }
}
