package application;

import db.DB;
import models.entities.persons.Author;
import models.services.AuthorService;

import java.time.LocalDate;

public class Program {

    public static void main(String[] args) {
        DB.connect();
        System.out.println();

        // Testes implementação LIVRO
        //BookTest bt = new BookTest();
        //bt.tests();

        // TESTES AUTOR
        AuthorService as = new AuthorService();

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


        DB.disconnect();
    }
}
