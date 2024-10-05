package models.dao;

import models.entities.Loan;
import models.entities.persons.Member;

import java.util.List;

public interface LoanDAO {

    void insert(Loan loan);
    void update(Loan loan);
    Loan findById(Integer id);
    List<Loan> findLoansByMember(Member member);
    List<Loan> findAllLoans();
}
