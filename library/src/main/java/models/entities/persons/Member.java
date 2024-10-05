package models.entities.persons;

import models.entities.Loan;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "members")
public class Member extends Person implements Comparable<Member> {

    private String email;
    private String telephone;
    private String address;
    private LocalDate associationDate;

    @OneToMany(mappedBy = "member")
    private Set<Loan> loans = new HashSet<>();

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Member() {
    }

    public Member(String name, String email, String telephone, String address, LocalDate associationDate) {
        super(name);
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.associationDate = associationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getAssociationDate() {
        return associationDate;
    }

    public void setAssociationDate(LocalDate associationDate) {
        this.associationDate = associationDate;
    }

    public Set<Loan> getLoans() {
        return loans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Member member = (Member) o;
        return Objects.equals(email, member.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email);
    }

    @Override
    public String toString() {
        return "| Name: " + getName() + " | Email: '" + email + " | Telephone: " + telephone + " | Address: " + address + " | Association Date: " + associationDate.format(fmt) + " | Quantity Loans: " + loans.size() + " |";
    }

    @Override
    public int compareTo(@NotNull Member o) {
        return this.getName().compareToIgnoreCase(o.getName());
    }
}
