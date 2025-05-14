package FamilyExpenses.Infrastructure.Persistences;

import FamilyExpenses.Domain.Entities.UserMember;
import FamilyExpenses.Domain.Exceptions.EntityAlreadyExistsException;
import FamilyExpenses.Domain.Exceptions.EntityNotFoundException;
import FamilyExpenses.Infrastructure.Configurations.Databases.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class UserMemberDao {

    private final EntityManagerFactory dbConnection;

    public UserMemberDao() {
        this.dbConnection = ConnectionFactory.connect();
    }

    public void save(UserMember member) throws EntityAlreadyExistsException, Exception {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = dbConnection.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(member);
            tx.commit();
        } catch (PersistenceException ex) {
            String msg = ex.getMessage().toLowerCase();
            if (msg.contains("duplicate") && msg.contains("primary")) {
                throw new EntityAlreadyExistsException("A UserMember with ID: " + member.getId() + " already exists.");
            }
            throw new Exception(msg);
        } catch (Exception ex) {
            throw new Exception("Internal DB error while saving UserMember ID: " + member.getId() + "\n" + ex.getMessage());
        } finally {
            if (tx != null && tx.isActive()) tx.rollback();
            if (em != null && em.isOpen()) em.close();
        }
    }

    public UserMember findById(String id) throws Exception {
        EntityManager em = null;
        try {
            em = dbConnection.createEntityManager();
            UserMember member = em.find(UserMember.class, id);
            if (member == null) {
                throw new EntityNotFoundException("UserMember with ID: " + id + " not found.");
            }
            return member;
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception ex) {
            throw new Exception("Internal DB error while retrieving UserMember ID: " + id);
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
    }

    public void update(UserMember member) throws Exception {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = dbConnection.createEntityManager();
            if (em.find(UserMember.class, member.getId()) == null) {
                throw new EntityNotFoundException("UserMember with ID: " + member.getId() + " not found.");
            }
            tx = em.getTransaction();
            tx.begin();
            em.merge(member);
            tx.commit();
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception ex) {
            throw new Exception("Internal DB error while updating UserMember ID: " + member.getId());
        } finally {
            if (tx != null && tx.isActive()) tx.rollback();
            if (em != null && em.isOpen()) em.close();
        }
    }

    public void delete(String id) throws Exception {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = dbConnection.createEntityManager();
            UserMember member = em.find(UserMember.class, id);
            if (member == null) {
                throw new EntityNotFoundException("UserMember with ID: " + id + " not found.");
            }
            tx = em.getTransaction();
            tx.begin();
            em.remove(member);
            tx.commit();
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception ex) {
            throw new Exception("Internal DB error while deleting UserMember ID: " + id);
        } finally {
            if (tx != null && tx.isActive()) tx.rollback();
            if (em != null && em.isOpen()) em.close();
        }
    }

    public List<UserMember> findAll() throws Exception {
        String query = "SELECT u FROM UserMember u";
        EntityManager em = null;
        try {
            em = dbConnection.createEntityManager();
            return em.createQuery(query, UserMember.class).getResultList();
        } catch (Exception ex) {
            throw new Exception("Internal DB error while retrieving all UserMembers.");
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
    }

    public long count() throws Exception {
        EntityManager em = null;
        try {
            em = dbConnection.createEntityManager();
            var query = "SELECT COUNT(m) FROM UserMember m";
            return em.createQuery(query, Long.class).getSingleResult();
        } catch (Exception ex) {
            throw new Exception("Internal DB error while counting UserMembers.");
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
    }
}
