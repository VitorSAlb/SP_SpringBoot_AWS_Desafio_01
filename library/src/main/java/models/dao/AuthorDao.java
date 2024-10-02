package models.dao;

import models.entities.persons.Author;

import java.util.List;

public interface AuthorDao {

    void insert(Author author);
    void update(Author author);
    void deleteByName(String name);
    Author findById(Integer Id);
    Author findByName(String Name);
    List<Author> findAll();
}
