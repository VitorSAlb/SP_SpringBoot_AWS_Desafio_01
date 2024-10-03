package models.dao.impl;

import exception.DefaultException;
import models.dao.GenericDAO;
import models.entities.books.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class BookDaoJ implements GenericDAO<Book> {

    private final EntityManager em;

    public BookDaoJ(EntityManager em) {
        this.em = em;
    }


    @Override
    public void insert(Book book) {
        try {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
            System.out.println("Insert done!");
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new DefaultException("Error insert: " + e.getMessage());
        }
    }

    @Override
    public void update(Book book) {
        try {
            em.getTransaction().begin();
            em.merge(book);
            em.getTransaction().commit();
            System.out.println("Update done!");
        } catch (RuntimeException e) {
            throw new DefaultException(e.getMessage());
        }

    }

    @Override
    public void deleteById(Integer Id) {
        try{
            Book b = findById(Id);
            if (b.getIsbn() != null) {
                em.getTransaction().begin();
                em.remove(b);
                em.getTransaction().commit();
                System.out.println("Deleted Book name: " + b.getTitle());
            } else {
                throw new DefaultException("Error: Book with Isbn: " + Id + " does note exist!");
            }
        } catch (RuntimeException e) {
            throw new DefaultException("Error: Unexpected error!");
        }
    }

    @Override
    public void deleteByName(String name) {
        Book b = findByName(name);
        try{
            if(b.getIsbn() != null) {
                em.getTransaction().begin();
                em.remove(b);
                em.getTransaction().commit();
                System.out.println("Deleted Author name: " + b.getTitle());
            } else {
                System.out.println("Error delete: Book with Name: " + name + " does not exist!");
            }
        } catch (RuntimeException e) {
            throw new DefaultException("Error delete: " + e.getMessage());
        }

    }

    @Override
    public Book findById(Integer Id) {
        return em.find(Book.class, Id);
    }

    @Override
    public Book findByName(String name) {
        Book book = findAll().stream().filter(b -> b.getTitle().equalsIgnoreCase(name)).findFirst().orElse(null);

        if (book == null) {
            System.out.println("Book not founded by name!");
        }

        return book;
    }

    @Override
    public List<Book> findAll() {
        Query query = em.createQuery("SELECT b FROM Book b");
        List<Book> books = query.getResultList();
        return books;
    }
}
