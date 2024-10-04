package models.entities.books;

import exception.DefaultException;
import models.entities.persons.Author;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book implements Comparable<Book> {

    @Id
    @Column(unique = true)
    private Integer isbn;

    private String title;
    private LocalDate publishDate;
    private Integer quantity;
    private Integer quantityLoans = 0;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    private String gender;

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Book() {
    }

    public Book(Integer isbn, String title, LocalDate publishDate, Integer quantity, Author author, String gender) {
        this.isbn = isbn;
        this.title = title;
        this.publishDate = publishDate;
        this.quantity = quantity;
        this.author = author;
        this.gender = gender;
    }

    public Integer getIsbn() {
        return isbn;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getQuantityLoans() {
        return quantityLoans;
    }

    public void setQuantityLoans(Integer quantityLoans) {
        this.quantityLoans = quantityLoans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public int compareTo(Book o) {
        return this.title.compareToIgnoreCase(o.title);
    }

    @Override
    public String toString() {
        return  "| isbn: " + isbn +
                " | title: " + title +
                " | publishDate: " + publishDate.format(fmt) +
                " | quantity: " + quantity +
                " | author: " + author.getName() +
                " | gender: " + gender + " |";
    }

    public void loanBook() {
        if (quantity <= 0 ){
            throw new DefaultException("This book isn't available for loan. Book ISBN: " + isbn);
        }
        quantity--;
        quantityLoans++;
    }

    public void returnBook() {
        quantity++;
        quantityLoans--;
    }
}
