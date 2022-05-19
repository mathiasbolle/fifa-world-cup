package service;

import java.util.List;

public interface GenericDao<T> {
    List<T> findAll();
    T update(T object);
    T get(Integer id);
    void delete(T object);
    void insert(T object);
    boolean exists(Long id);
}
