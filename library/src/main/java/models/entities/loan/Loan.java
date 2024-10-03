package models.entities.loan;

import exception.DefaultException;
import models.entities.books.Book;
import models.entities.enums.StateLoan;
import models.entities.persons.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "book_isbn")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime loanDate;
    private LocalDateTime returnDate;

    @Enumerated(EnumType.STRING)
    private StateLoan stateLoan;
    private Double fine;

    public Loan() {
    }

    public Loan(Book book, Member member, LocalDateTime loanDate, LocalDateTime returnDate, StateLoan stateLoan, Double fine) {
        this.book = book;
        this.member = member;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.stateLoan = stateLoan;
        this.fine = fine;
    }

    public Integer getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public StateLoan getStateLoan() {
        return stateLoan;
    }

    public void setStateLoan(StateLoan stateLoan) {
        this.stateLoan = stateLoan;
    }

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", book=" + book +
                ", member=" + member +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                ", stateLoan=" + stateLoan +
                ", fine=" + fine +
                '}';
    }

    //VERIFICAR ISSO DAQ, NN SEI SE VAI FUNICONAR NA CLASSE BOOK TBM
    public void loanBook(){
        if (book.getQuantity() <= 0) {
            throw new DefaultException("This book isn't available for loan. Book ISBN: " + book.getIsbn());
        }
        book.loanBook(book);
        this.loanDate = LocalDateTime.now();
        this.stateLoan = StateLoan.ACTIVE;
    }

    public void returnBook() {
        book.returnBook();
        this.stateLoan = StateLoan.COMPLETED;
    }


}
