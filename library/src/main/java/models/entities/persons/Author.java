package models.entities.persons;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "authors")
public class Author extends Person {

    private LocalDate birthDate;
    private String nationality;
    private String biography;

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

    @Override
    public String toString() {
        return "Author {" +
                "name = " + getName() +
                ", birthDate = " + birthDate +
                ", nationality = '" + nationality + '\'' +
                ", biography = '" + biography + '\'' +
                '}';
    }
}
