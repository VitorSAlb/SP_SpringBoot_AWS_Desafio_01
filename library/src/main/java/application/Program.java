package application;

import db.DB;
import models.entities.persons.Author;
import models.services.AuthorService;
import models.services.BookService;

import java.time.LocalDate;

public class Program {

    public static void main(String[] args) {
        DB.connect();
        System.out.println();

        TestCrud tc = new TestCrud();
        AuthorService as = new AuthorService();
        BookService bs = new BookService();



        // TESTS AUTHOR
        tc.testAuthor();

        // Testes implementação LIVRO
        tc.testBook();

        //


        DB.disconnect();
    }
}
