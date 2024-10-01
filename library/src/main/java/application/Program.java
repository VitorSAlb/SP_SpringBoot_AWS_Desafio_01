package application;

import models.entities.persons.Author;
import models.entities.persons.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Library");
        EntityManager em = emf.createEntityManager();

        Member m1 = new Member(null, "Vitor", "vitor@gmail.com", "Salvador","71996144188", LocalDate.now());
        Author a1 = new Author(null, "Oda", "Japan", "Write One Piece");
        System.out.println(m1);
        System.out.println(a1);

        em.getTransaction().begin();

        em.persist(m1);
        em.persist(a1);

        em.getTransaction().commit();

        System.out.println("Ready! ");
        em.close();
        emf.close();
    }
}
