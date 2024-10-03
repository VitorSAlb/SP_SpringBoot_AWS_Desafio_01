package models.dao;

import models.entities.books.Book;

import java.util.List;

public interface genericDAO<T> {

    void insert(T t);
    void update(T t);
    void deleteById(Integer Id);
    void deleteByName(String name);
    T findById(Integer Id);
    T findByName(String Name);
    List<T> findAll();

}
