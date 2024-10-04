package models.entities.persons;

import models.entities.books.Book;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author extends Person {

    private LocalDate birthDate;
    private String nationality;
    private String biography;

    @OneToMany(mappedBy = "author")
    private Set<Book> books = new HashSet<>();

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Author() {
    }

    public Author(String name, LocalDate birthDate, String nationality, String biography) {
        super(name);
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.biography = biography;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "| name: " + getName() + " | birthDate: " + birthDate.format(fmt) + " | nationality: '" + nationality + " | biography: '" + biography + " |\n";
    }
}
