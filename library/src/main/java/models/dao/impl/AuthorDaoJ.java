package models.dao.impl;

import exception.DefaultException;
import models.dao.GenericDAO;
import models.entities.persons.Author;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AuthorDaoJ implements GenericDAO<Author> {

    private final EntityManager em;

    public AuthorDaoJ(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(Author author) {
        try {
            em.getTransaction().begin();
            em.persist(author);
            em.getTransaction().commit();
            System.out.println("Done, insert! Generated ID: " + author.getId());
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new DefaultException("Error insert: " + e.getMessage());
        }
    }

    @Override
    public void update(Author author) {
        try {
            em.getTransaction().begin();
            em.merge(author);
            em.getTransaction().commit();
            System.out.println("Update is done!");
        } catch (RuntimeException e) {
            throw new DefaultException("Error Update: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(Integer id) {
        Author a = findById(id);
        try{
            if(a.getId() != null) {
                em.getTransaction().begin();
                em.remove(a);
                em.getTransaction().commit();
                System.out.println("Deleted Author name: " + a.getName());
            } else {
                System.out.println("Error delete: Author with Id: " + id + " does not exist!");
            }
        } catch (RuntimeException e) {
            throw new DefaultException("Error delete: " + e.getMessage());
        }
    }

    @Override
    public void deleteByName(String name) {
        Author a = findByName(name);
        try{
            //System.out.println("Test => " + a.getName());

            if(a.getId() != null) {
                em.getTransaction().begin();
                em.remove(a);
                em.getTransaction().commit();
                System.out.println("Deleted Author name: " + a.getName());
            } else {
                System.out.println("Error delete: Author with Name: " + name + " does not exist!");
            }
        } catch (RuntimeException e) {
            throw new DefaultException("Error delete: " + e.getMessage());
        }
    }

    @Override
    public Author findById(Integer Id) {
        return em.find(Author.class, Id);
    }

    @Override
    public Author findByName(String name) {
        try {
            Query query = em.createQuery("SELECT a FROM Author a WHERE a.name = :name");
            query.setParameter("name", name);
            return (Author) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Author> findAll() {
        Query query = em.createQuery("SELECT a FROM Author a");
        List<Author> authors = query.getResultList();
        return authors;
    }
}
