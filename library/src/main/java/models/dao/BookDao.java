package models.dao;

import models.entities.books.Book;

import java.util.List;

public interface BookDao {

    void insert(Book book);
    void update(Book book);
    void deleteById(Integer Id);
    Book findById(Integer Id);
    Book findByName(String Name);
    List<Book> findAll();
}
