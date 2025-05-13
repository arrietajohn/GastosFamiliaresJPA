/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FamilyExpenses.Infrastructure.Persistences;

import FamilyExpenses.Infrastructure.Configurations.Databases.ConnectionFactory;
import FamilyExpenses.Domain.Entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author pc
 */


public class UserDao {

    private EntityManagerFactory connectionFactory;

    public UserDao() {
        connectionFactory = ConnectionFactory.connect();
    }

    public void save(User user) throws Exception {
        EntityTransaction transaction = null;
        EntityManager entityManager = null;
        try {
            entityManager = connectionFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            String errorMessage = "Error while saving User: " + user.getCode();
            throw new Exception(errorMessage);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public User findById(String id) throws Exception {
        EntityManager entityManager = null;
        try {
            entityManager = connectionFactory.createEntityManager();
            User user = entityManager.find(User.class, id);
            if (user == null) {
                String errorMessage = "User with ID: " + id + " does not exist";
                throw new Exception(errorMessage);
            }
            return user;
        } catch (Exception e) {
            throw e;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public List<User> findAll() {
        EntityManager entityManager = connectionFactory.createEntityManager();
        String query = "SELECT u FROM User u"; // Ensure entity name is `User`
        List<User> userList = entityManager.createQuery(query, User.class).getResultList();
        entityManager.close();
        return userList;
    }

    public void update(User user) throws Exception {
        // Ensure user exists before attempting update
        this.findById(user.getCode());

        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = connectionFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            String errorMessage = "Error while updating User: " + user.getCode();
            throw new Exception(errorMessage);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public void deleteById(String id) throws Exception {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = connectionFactory.createEntityManager();
            User user = entityManager.find(User.class, id);
            if (user == null) {
                throw new Exception("User with ID: " + id + " does not exist");
            }
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            String errorMessage = "Error while deleting User: " + id + "\n" + e.getMessage();
            throw new Exception(errorMessage);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
