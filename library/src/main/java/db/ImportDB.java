package db;

import models.entities.Book;
import models.entities.persons.Author;
import models.entities.persons.Member;
import models.services.AuthorService;
import models.services.BookService;
import models.services.MemberService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ImportDB {

    private static final BookService bs = new BookService();
    private static final MemberService ms = new MemberService();
    private static final AuthorService as = new AuthorService();
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public void importMembers(){
        Member m1 = new Member("Vitor", "vitor@gmail.com", "8823813", "Rua 234", LocalDate.now());
        Member m2 = new Member("Lis", "lis@gmail.com", "3123123", "Rua 323", LocalDate.now());
        Member m3 = new Member("Geo", "geo@gmail.com", "4124124", "Rua 234", LocalDate.now());
        Member m4 = new Member("Carlos", "carlos@gmail.com", "5252342", "Rua 234", LocalDate.now());
        Member m5 = new Member("Yelo", "yelo@gmail.com", "62316237", "Rua 323", LocalDate.now());

        try {
            ms.newMember(m1);
            ms.newMember(m2);
            ms.newMember(m3);
            ms.newMember(m4);
            ms.newMember(m5);
        } catch (RuntimeException e) {
            System.out.println("Members already imported!");
        }

    }

    public void importAuthors(){
        Author a1 = new Author("Raphael Montes", LocalDate.parse("22/09/1990", fmt), "Brazilian", "Born in Rio de Janeiro");
        Author a2 = new Author("J. K. Rowling", LocalDate.parse("31/07/1965", fmt), "British", "Born in Yate");
        Author a3 = new Author("Edney Silvestre", LocalDate.parse("27/04/1950", fmt), "Brazilian", "Born in Rio de Janeiro");
        Author a4 = new Author("L. Frank Baum", LocalDate.parse("15/05/1856", fmt), "EUA", "Born in New York");

        try {
            as.newAuthor(a1);
            as.newAuthor(a2);
            as.newAuthor(a3);
            as.newAuthor(a4);
        } catch (RuntimeException e) {
            System.out.println("Authors already imported!");
        }
    }

    public void importBooks() {
        Author a1 = as.searchAuthor("Raphael Montes");
        Author a2 = as.searchAuthor("J. K. Rowling");
        Author a3 = as.searchAuthor("Edney Silvestre");

        Book b1 = new Book(7624, "Jantar Secreto", LocalDate.parse("14/11/2016", fmt), 15, a1, "Thriller");
        Book b2 = new Book(934, "Harry Potter And The Chamber Of Secrets", LocalDate.parse("02/07/1998", fmt), 15, a2, "Fantasy");
        Book b3 = new Book(3123, "Harry Potter And The Prisoner of Azkaban", LocalDate.parse("08/07/1999", fmt), 15, a2, "Fantasy");
        Book b4 = new Book(31322, "Se eu fechar os olhos agora", LocalDate.parse("01/01/2009", fmt), 15, a3, "thriller");
        Book b5 = new Book(97462, "Oz", LocalDate.parse("17/05/1900", fmt), 15, new Author(), "fantasia");

        try {
            bs.newBook(b1);
            bs.newBook(b2);
            bs.newBook(b3);
            bs.newBook(b4);
            bs.newBook(b5);
        } catch (RuntimeException e) {
            System.out.println("Books already imported!");
        }
    }
}
