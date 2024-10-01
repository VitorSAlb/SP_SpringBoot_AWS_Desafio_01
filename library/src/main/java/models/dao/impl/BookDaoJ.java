package models.dao.impl;

import db.DbException;
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
        System.out.println("teste => " + book.getTitle());
        em.persist(book);
        em.getTransaction().commit();
        System.out.println("Done, Insert!");
    }

    @Override
    public void update(Book book) {
        

    }

    @Override
    public void deleteById(Integer Id) {
        try{
            Book b = em.find(Book.class, Id);

            System.out.println("teste => " + b.getTitle());

            if (b != null) {
                em.getTransaction().begin();
                em.remove(b);
                em.getTransaction().commit();
                System.out.println("Deleted Book name: " + b.getTitle());
            } else {
                throw new DbException("Error: Book with Isbn: " + Id + " does note exist!");
            }
        } catch (RuntimeException e) {
            throw new DbException("Error: Unexpected error!");
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
            throw new DbException("Book not founded by name!");
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
