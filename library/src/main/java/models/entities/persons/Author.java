//package models.entities.persons;
//
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "Authors")
//public class Author extends Person {
//
//    private String nationality;
//    private String biography;
//
//    public Author(Integer id, String name, String nationality, String biography) {
//        super(id, name);
//        this.nationality = nationality;
//        this.biography = biography;
//    }
//
//    public String getNationality() {
//        return nationality;
//    }
//
//    public void setNationality(String nationality) {
//        this.nationality = nationality;
//    }
//
//    public String getBiography() {
//        return biography;
//    }
//
//    public void setBiography(String biography) {
//        this.biography = biography;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Author { " +
//                "Id = '" + getId() + '\'' +
//                ", Name = " + getName() + '\'' +
//                ", nationality = " + nationality + '\'' +
//                ", biography = " + biography + '\'' +
//                '}';
//    }
//}
