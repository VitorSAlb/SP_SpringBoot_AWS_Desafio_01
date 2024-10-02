package models.entities.books;

//import models.entities.persons.Author;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "books")
public class Book implements Comparable<Book>{
// MUDAR A IMPLEMENTAÇÃO DE AUTORES e GENEROS

    @Id
    @Column(unique = true)
    private Integer isbn;

    private String title;
    private LocalDate publishDate;
    private Integer quantity;

    private String author;
    private String gender;



    public Book() {
    }

    public Book(Integer isbn, String title, LocalDate publishDate, Integer quantity, String author, String gender) {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        return Objects.hashCode(isbn);
    }

    @Override
    public int compareTo(Book otherBook) {
        return this.isbn.compareTo(otherBook.getIsbn());
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", publishDate=" + publishDate +
                ", quantity=" + quantity +
                ", gender=" + gender +
                ", author=" + author +
                '}';
    }
}
