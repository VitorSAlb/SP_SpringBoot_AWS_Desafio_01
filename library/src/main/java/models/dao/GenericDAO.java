package models.dao;

import java.util.List;

public interface GenericDAO<T> {

    void insert(T t);
    void update(T t);
    void deleteById(Integer Id);
    void deleteByName(String name);
    T findById(Integer Id);
    T findByName(String Name);
    List<T> findAll();

}
