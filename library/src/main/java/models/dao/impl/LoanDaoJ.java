package models.dao.impl;

import exception.DefaultException;
import models.dao.LoanDAO;
import models.entities.enums.StateLoan;
import models.entities.loan.Loan;
import models.entities.persons.Member;

import javax.persistence.EntityManager;
import java.util.List;

public class LoanDaoJ implements LoanDAO {

    private final EntityManager em;

    public LoanDaoJ(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(Loan loan) {
        try {
            em.getTransaction().begin();
            em.persist(loan);
            em.getTransaction().commit();
            System.out.println("Insert done!");
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new DefaultException("Error insert: " + e.getMessage());
        }
    }

    @Override
    public void update(Loan loan) {
        try {
            em.getTransaction().begin();
            em.merge(loan);
            em.getTransaction().commit();
            System.out.println("Update done!");
        } catch (RuntimeException e) {
            throw new DefaultException(e.getMessage());
        }
    }

    @Override
    public Loan findById(Integer id) {
        return em.find(Loan.class, id);
    }

    @Override
    public List<Loan> findLoansByMember(Member member) {
        return em.createQuery("SELECT l FROM Loan l WHERE l.member = :member AND (l.stateLoan = :activeState OR l.stateLoan = :lateState)", Loan.class)
                .setParameter("member", member)
                .setParameter("activeState", StateLoan.ACTIVE)
                .setParameter("lateState", StateLoan.LATE)
                .getResultList();
    }


    @Override
    public List<Loan> findAllLoans() {
        return em.createQuery("SELECT l FROM Loan l", Loan.class).getResultList();
    }
}
