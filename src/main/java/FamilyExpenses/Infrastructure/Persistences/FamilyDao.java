package FamilyExpenses.Infrastructure.Persistences;

import FamilyExpenses.Infrastructure.Configurations.Databases.ConnectionFactory;
import FamilyExpenses.Domain.Entities.Family;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class FamilyDao {

    private final EntityManagerFactory connectionFactory;

    public FamilyDao() {
        this.connectionFactory = ConnectionFactory.connect();
    }

    public void save(Family family) throws Exception {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = connectionFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(family);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            String message = "Error while saving the Family.";
            throw new Exception(message, e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}

