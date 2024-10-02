package application;

import db.DB;
import models.dao.impl.BookDaoJ;
import models.entities.books.Book;
import models.entities.persons.Author;
import models.services.AuthorService;
import models.services.BookService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TestCrud {

    private static BookService bs = new BookService();
    private static AuthorService as = new AuthorService();
    private static Scanner sc = new Scanner(System.in);

    public TestCrud() {
    }

    public void testBook(){
        Book book;

        System.out.println("------- Insert BOOK -------");
        System.out.println();

        Author author1 = as.searchAuthor("Echiro Oda");
        Book newBook = new Book(21, "Harry Potter", LocalDate.now(), 2, author1, "sci-fi");
        bs.newBook(newBook);

        System.out.println();
        System.out.println("------- END Insert BOOK -------");
        System.out.println();

        System.out.println("------- Delete BOOK -------");
        System.out.println();


        Author newAuthor = new Author("num sei", LocalDate.now(), "adsd", "dsadas");
        Book newBookDelete = new Book(22, "Narnia", LocalDate.now(), 2, newAuthor, "fantasia");
        bs.newBook(newBookDelete);
        bs.deleteBook(22);

        System.out.println();
        System.out.println("------- END Delete BOOK -------");
        System.out.println();

        System.out.println("------- Show BOOK BY ID -------");
        System.out.println();

        book = bs.searchBook(1);
        System.out.println(book);

        System.out.println();
        System.out.println("------- END BOOKS BY ID -------");
        System.out.println();

        System.out.println("------- Show BOOK NAME -------");
        System.out.println();

        book = bs.searchBook("Romance Down");
        System.out.println(book);

        System.out.println();
        System.out.println("------- END BOOK NAME -------");
        System.out.println();

        System.out.println("------- Update BOOK -------");
        System.out.println();

        Author authorToUpdate = new Author("New Author", LocalDate.now(), "USA", "New Bio");
        newBook = new Book(21, "Harry", LocalDate.now(), 2, authorToUpdate, "sci-fi");
        bs.updateBook(newBook);

        System.out.println();
        System.out.println("------- END Update BOOK -------");
        System.out.println();

        System.out.println("------- Show ALL BOOKS -------");
        System.out.println();
        List<Book> booksAll = bs.listBooks();

        for (Book b : booksAll) {
            System.out.println(b);
        }

        System.out.println();
        System.out.println("------- END Show ALL BOOKS -------");
        System.out.println();

        System.out.println();
    }

    public void testAuthor(){
        Author a1 = new Author("Echiro Oda", LocalDate.now(), "Japan", "Made One Piece");
        Author a2 = new Author("J. K. Rolling", LocalDate.now(), "UK", "Made HP");
        Author a3 = new Author("Errado", LocalDate.now(), "err", "err");
        Author a4 = new Author("Deleted", LocalDate.now(), "del", "del");
        as.newAuthor(a1);
        as.newAuthor(a2);
        as.newAuthor(a3);
        as.newAuthor(a4);

        Author aU = as.searchAuthor("Errado");
        aU.setBiography("Updated");
        System.out.println("ID: " + aU.getId());
        as.updateAuthor(aU);
        System.out.println(as.searchAuthor("errado"));
        as.deleteAuthor("Deleted");
        as.listAuthors();
    }

    public void testCreateBook() {
        System.out.println("Enter book data: ");

    }
}
