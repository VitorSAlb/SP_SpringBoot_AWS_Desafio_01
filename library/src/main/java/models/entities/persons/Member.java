//package models.entities.persons;
//
//import javax.persistence.Entity;
//import javax.persistence.Table;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "members")
//public class Member extends Person {
//
//    private LocalDate associationDate;
//    //private Set<Loan> loan;
//
//    public Member(Integer id, String name, String email, String address, String telephone, LocalDate associationDate) {
//        super(id, name, email, address, telephone);
//        this.associationDate = associationDate;
//        //this.loan = new TreeSet<>();
//    }
//
//    public LocalDate getAssociationDate() {
//        return associationDate;
//    }
//
//    public void setAssociationDate(LocalDate associationDate) {
//        this.associationDate = associationDate;
//    }
//
////    public Set<Loan> getLoan() {
////        return loan;
////    }
////
////    public void addLoan(Loan newLoan) {
////        loan.add(newLoan);
////    }
//
//
//    @Override
//    public String toString() {
//        return "Member {" +
//                " Id = " + getId() +
//                " Name = " + getName() +
//                " Email = " + getEmail() +
//                " Address = " + getAddress() +
//                " Tel = " + getTelephone() +
//                " associationDate = " + associationDate +
//                '}';
//    }
//}
