package models.dao.impl;

import models.dao.BookDao;
import models.entities.books.Book;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class BookDaoJ implements BookDao {

    private EntityManager em;

    public BookDaoJ(EntityManager em) {
        this.em = em;
    }


    @Override
    public void insert(Book book) {
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        System.out.println("Done, Insert!");
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void deleteById(Integer Id) {

    }

    @Override
    public Book findById(Integer Id) {
        return null;
    }

    @Override
    public Book findByName(String Name) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        Query query = em.createQuery("SELECT b FROM Book b");
        List<Book> books = query.getResultList();
        return books;
    }
}
