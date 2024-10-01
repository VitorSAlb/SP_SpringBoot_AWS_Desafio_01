package application;

import db.DB;
import models.dao.BookDao;
import models.dao.impl.BookDaoJ;
import models.entities.books.Book;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        DB.connect();
        System.out.println();


        System.out.println("------- Show ALL BOOKS -------");
        System.out.println();
        BookDaoJ bookDao = new BookDaoJ(DB.getEntityManager());
        List<Book> books = bookDao.findAll();

        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println();
        System.out.println("------- END Show ALL BOOKS -------");
        System.out.println();

        System.out.println();
        DB.disconnect();
    }
}
