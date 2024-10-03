package models.services;

import exception.DefaultException;
import models.dao.DaoFactory;
import models.dao.impl.LoanDaoJ;
import models.entities.books.Book;
import models.entities.enums.StateLoan;
import models.entities.loan.Loan;
import models.entities.persons.Member;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class LoanService {

    private final LoanDaoJ loanDAO = DaoFactory.createLoanDao();
    private final BookService bs = new BookService();

    public LoanService() {
    }

    public void newLoan(Loan loan) {
        Book book = loan.getBook();

        if(loan.getBook().getQuantity() <= 0 ) {
            throw new DefaultException("This boos isn't available for loan!");
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

        if (returnLDT.isAfter(loan.getReturnDate())) {
            double fine = (returnLDT.getDayOfMonth() - loan.getReturnDate().getDayOfMonth()) * 5.0;
            loan.setFine(fine);
        }

        loan.setStateLoan(StateLoan.COMPLETED);
        loanDAO.update(loan);

        Book book = loan.getBook();
        book.returnBook();
        bs.updateBook(book);
    }

}
