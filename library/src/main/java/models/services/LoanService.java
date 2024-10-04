package models.services;

import exception.DefaultException;
import models.dao.DaoFactory;
import models.dao.impl.LoanDaoJ;
import models.entities.books.Book;
import models.entities.enums.StateLoan;
import models.entities.loan.Loan;
import models.entities.persons.Member;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;

public class LoanService {

    private final LoanDaoJ loanDAO = DaoFactory.createLoanDao();
    private final BookService bs = new BookService();

    public LoanService() {
    }

    public void newLoan(Loan loan) {

        Set<Loan> loasn = loan.getMember().getLoans();

        for (Loan l: loasn) {
            if (l.getBook().getIsbn().equals(loan.getBook().getIsbn())) {
                throw new DefaultException("It's not possible to borrow the same book more than once.");
            }

            if (l.getFine() > 0.0) {
                throw new DefaultException("We cannot make the loan because the member has an unpaid fine!");
            }
        }



        Book book = loan.getBook();

        if(loan.getBook().getQuantity() <= 0 ) {
            throw new DefaultException("This book isn't available for loan, Book name: " + loan.getBook().getTitle() );
        }

        List<Loan> activeLoans = loanDAO.findLoansByMember(loan.getMember());
        if (activeLoans.size() >= 5) {
            throw new DefaultException("Member has reached the max number of loans!");
        }

        loanDAO.insert(loan);
        book.loanBook();
        bs.updateBook(book);
    }

    public void returnLoan(Loan loan, LocalDateTime returnLDT) {

        if (returnLDT.isBefore(loan.getLoanDate())) {
            throw new DefaultException("The return date cannot be before the loan date!");
        }

        LocalDateTime dueDate = loan.getLoanDate().plusDays(5);

        loan.setReturnDate(returnLDT);
        loan.setStateLoan(StateLoan.COMPLETED);
        loan.setFine(0.0);

        if (returnLDT.isAfter(dueDate) && !returnLDT.isEqual(dueDate)) {
            long overdueDays = java.time.Duration.between(dueDate, returnLDT).toDays();
            loan.setFine(overdueDays * 5.0);
        }

        loanDAO.update(loan);

        Book book = loan.getBook();
        book.returnBook();
        bs.updateBook(book);
    }

    public Loan findLoan(Member member, Book book) {
        List<Loan> listL = loanDAO.findLoansByMember(member);
        Loan loan = listL.stream().filter(l -> l.getBook().getIsbn().equals(book.getIsbn())).findFirst().orElse(null);

        if (loan == null) {
            throw new DefaultException("No loan found for book: " + book.getIsbn());
        }

        return loan;
    }

    public void verifyLoan(Loan loan) {

        if (loan.getStateLoan() != StateLoan.COMPLETED) {
            LocalDateTime dueDate = loan.getLoanDate().plusDays(5);
            LocalDateTime now = LocalDateTime.now();

            LocalDate test1 = loan.getLoanDate().toLocalDate();
            LocalDate now2 = LocalDate.now();

            if (now.isAfter(dueDate)) {
                Duration duration = Duration.between(test1.atTime(0,0), now2.atTime(0,0));

                System.out.println(test1);
                System.out.println(now2);
                long daysLate = duration.toDays();
                System.out.println("Days late: " + daysLate);

                double fine = daysLate * 5.0;
                loan.setFine(fine);
                loan.setStateLoan(StateLoan.LATE);
                loanDAO.update(loan);
            }
        }
    }

    public List<Loan> listAllLoan() {
        return loanDAO.findAllLoans();
    }
}

