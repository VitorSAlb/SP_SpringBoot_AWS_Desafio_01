//package models.entities.persons;
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//public abstract class Person {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer Id;
//    private String name;
//    private String email;
//    private String address;
//    private String telephone;
//
//    public Person(Integer id, String name) {
//        Id = id;
//        this.name = name;
//        this.email = null;
//        this.address = null;
//        this.telephone = null;
//    }
//
//    public Person(Integer id, String name, String email, String address, String telephone) {
//        Id = id;
//        this.name = name;
//        this.email = email;
//        this.address = address;
//        this.telephone = telephone;
//    }
//
//    public Integer getId() {
//        return Id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getTelephone() {
//        return telephone;
//    }
//
//    public void setTelephone(String telephone) {
//        this.telephone = telephone;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return Objects.equals(name, person.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(name);
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "Id=" + Id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", address='" + address + '\'' +
//                ", telephone='" + telephone + '\'' +
//                '}';
//    }
//}
