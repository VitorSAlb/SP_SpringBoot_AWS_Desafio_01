package models.dao.impl;

import db.DbException;
import models.dao.BookDao;
import models.entities.books.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class BookDaoJ implements BookDao {

    private EntityManager em;

    public BookDaoJ(EntityManager em) {
        this.em = em;
    }


    @Override
    public void insert(Book book) {
        Book b = findById(book.getIsbn());

        if (b == null) {
            try {
                em.getTransaction().begin();
                System.out.println("teste => " + book.getTitle());
                em.persist(book);
                em.getTransaction().commit();
                System.out.println("Done, Insert!");
            } catch (RuntimeException e) {
                throw new DbException("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Book: " + b.getTitle() + " already exists!");
        }


    }

    @Override
    public void update(Book book) {
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(book);
            transaction.commit();
            System.out.println("Update is done!");
        } catch (RuntimeException e) {
            throw new DbException(e.getMessage());
        }

    }

    @Override
    public void deleteById(Integer Id) {
        try{
            Book b = findById(Id);

            // TESTE sistema
            System.out.println("teste => " + b.getTitle());

            if (b.getIsbn() != null) {
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
