package application;

import db.DB;
import models.dao.BookDao;
import models.dao.impl.BookDaoJ;
import models.entities.books.Book;

import java.time.LocalDate;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        DB.connect();
        System.out.println();

        BookDaoJ bookDao = new BookDaoJ(DB.getEntityManager());

        System.out.println("------- Insert BOOK -------");
        System.out.println();

//        Book newBook = new Book(21, "Harry Potter", LocalDate.now(), 2, "J.K. Rolling", "sci-fi");
//        bookDao.insert(newBook);

        System.out.println();
        System.out.println("------- END Insert BOOK -------");
        System.out.println();


        System.out.println("------- Show ALL BOOKS -------");
        System.out.println();
        List<Book> booksAll = bookDao.findAll();

        for (Book book : booksAll) {
            System.out.println(book);
        }

        System.out.println();
        System.out.println("------- END Show ALL BOOKS -------");
        System.out.println();

        System.out.println();
        DB.disconnect();
    }
}
