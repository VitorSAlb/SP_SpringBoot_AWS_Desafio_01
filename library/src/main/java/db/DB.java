package db;

import exception.ConnectionException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DB {

    private static EntityManager entityManager;
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("Library");

    public static void connect() {
        try {
            entityManager = factory.createEntityManager();
            System.out.println("Connection Stated...");
        } catch (RuntimeException e) {
            throw new ConnectionException("Error Connection: " + e.getMessage());
        }
    }

    public static void closeEM() {
        try {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
                System.out.println("EntityManager closed");
            }
        } catch (RuntimeException e) {
            throw new ConnectionException("Error while closing EntityManager: " + e.getMessage());
        }
    }

    public static void closeFactory() {
        try {
            if (factory != null && factory.isOpen()) {
                factory.close();
                System.out.println("EntityManagerFactory closed");
            }
        } catch (RuntimeException e) {
            throw new ConnectionException("Error while closing EntityManagerFactory: " + e.getMessage());
        }
    }


    public static void disconnect() {
        closeEM();
        closeFactory();
        System.out.println("Disconnected...");
    }

    public static EntityManager getEntityManager(){ return entityManager; }
}
