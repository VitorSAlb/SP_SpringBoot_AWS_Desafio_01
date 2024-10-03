package models.controllers;

import models.entities.books.Book;
import models.entities.loan.Loan;
import models.entities.persons.Member;
import models.services.BookService;
import models.services.LoanService;
import models.services.MemberService;

import java.time.LocalDateTime;

public class LoanController {

    private final LoanService ls = new LoanService();
    private final MemberService ms = new MemberService();
    private final BookService bs = new BookService();

    public LoanController() {
    }

    public void borrowBook(String email, Integer isbn, LocalDateTime loanDate) {
        Member m = ms.searchMember(email);
        Book b = bs.searchBook(isbn);

        try {
            Loan l = new Loan(b, m, loanDate);
            ls.newLoan(l);
            System.out.println("New loan done!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void returnBook(String email, Integer isbn, LocalDateTime returnDate) {
        Loan loan = ls.findLoan(ms.searchMember(email),bs.searchBook(isbn));

        ls.returnLoan(loan, returnDate);
        System.out.println("Loan returned successfully! :)");
    }

}
