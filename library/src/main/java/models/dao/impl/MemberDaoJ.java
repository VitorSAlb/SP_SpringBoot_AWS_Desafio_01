package models.dao.impl;

import exception.DefaultException;
import models.dao.GenericDAO;
import models.entities.persons.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class MemberDaoJ implements GenericDAO<Member> {

    private final EntityManager em;

    public MemberDaoJ(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(Member member) {
        Member m = findByName(member.getName());

        if (m == null) {
            try {
                em.getTransaction().begin();
                em.persist(member);
                em.getTransaction().commit();
                System.out.println("Done, insert! Generated ID: " + member.getId());
            } catch (RuntimeException e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                throw new DefaultException("Error insert: " + e.getMessage());
            }
        } else {
            System.out.println(member.getClass().getName() + ": " + member.getName() + " already exists!");
        }
    }

    @Override
    public void update(Member member) {
        try {
            em.getTransaction().begin();
            em.merge(member);
            em.getTransaction().commit();
            System.out.println("Update is done!");
        } catch (RuntimeException e) {
            throw new DefaultException("Error Update: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(Integer Id) {
        Member m = findById(Id);
        try{
            // System.out.println("Test => " + a.getName());

            if(m.getId() != null) {
                em.getTransaction().begin();
                em.remove(m);
                em.getTransaction().commit();
                System.out.println("Deleted "+ m.getClass().getName() +" name: " + m.getName());
            } else {
                System.out.println("Error delete: "+ m.getClass().getName() +" with Id: " + Id + " does not exist!");
            }
        } catch (RuntimeException e) {
            throw new DefaultException("Error delete: " + e.getMessage());
        }
    }

    @Override
    public void deleteByName(String name) {
        Member mem = findByName(name);
        try{
            if(mem.getId() != null) {
                em.getTransaction().begin();
                em.remove(mem);
                em.getTransaction().commit();
                System.out.println("Deleted "+ mem.getClass().getName() +" name: " + mem.getName());
            } else {
                System.out.println("Error delete: "+ mem.getClass().getName() +" with Name: " + name + " does not exist!");
            }
        } catch (RuntimeException e) {
            throw new DefaultException("Error delete: " + e.getMessage());
        }
    }

    @Override
    public Member findById(Integer Id) {
        return em.find(Member.class, Id);
    }

    @Override
    public Member findByName(String name) {
        try {
            Query query = em.createQuery("SELECT m FROM Member m WHERE m.name = :name");
            query.setParameter("name", name);
            return (Member) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Member> findAll() {
        Query query = em.createQuery("SELECT m FROM Member m");
        List<Member> members = query.getResultList();
        return members;
    }
}
