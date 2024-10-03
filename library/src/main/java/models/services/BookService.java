package models.services;

import db.DB;
import models.dao.DaoFactory;
import models.dao.impl.BookDaoJ;
import models.entities.books.Book;

import java.util.List;

public class BookService {

    private final BookDaoJ bookDAO = DaoFactory.createBookDao();

    public void newBook(Book book) {
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
