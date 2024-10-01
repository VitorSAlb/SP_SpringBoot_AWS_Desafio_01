package application;

import db.DB;
import models.dao.BookDao;
import models.dao.impl.BookDaoJ;
import models.entities.books.Book;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        DB.connect();

        BookDaoJ bookDao = new BookDaoJ(DB.getEntityManager());
        List<Book> books = bookDao.findAll();

        for (Book book : books) {
            System.out.println(book.getTitle());
        }

        DB.disconnect();
    }
}
