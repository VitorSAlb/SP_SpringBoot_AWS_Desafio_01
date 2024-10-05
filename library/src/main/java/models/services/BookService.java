package models.services;

import exception.DefaultException;
import models.dao.DaoFactory;
import models.dao.impl.BookDaoJ;
import models.entities.Book;

import java.util.List;

public class BookService {

    private final BookDaoJ bookDAO = DaoFactory.createBookDao();

    public BookService() {
    }

    public void newBook(Book book) {

        Book existingBook = searchBook(book.getIsbn());
        if (existingBook != null) {
            throw new DefaultException("Book: " + book.getTitle() + " already exists!");
        }

        if (book.getIsbn().toString().length() > 12) {
            throw new DefaultException("Your ISBN has more than 12 digits");
        }

        if (book.getQuantity() <= 0 ) {
            throw new DefaultException("At the very least, you need to have a book for insertion");
        }

        bookDAO.insert(book);
    }

    public void updateBook(Book book) {
        bookDAO.update(book);
    }

    public void deleteBook(Integer isbn) {
        bookDAO.deleteById(isbn);
    }

    public Book searchBook(Integer isbn) {
        return bookDAO.findById(isbn);
    }

    public Book searchBook(String title){
        return  bookDAO.findByName(title);
    }

    public List<Book> listBooks() {
        return bookDAO.findAll();
    }

}
