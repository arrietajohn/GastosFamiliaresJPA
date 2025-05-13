package FamilyExpenses.Infrastructure.Configurations.Databases;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class ConnectionFactory {

    private static EntityManagerFactory connection;

    public static EntityManagerFactory connect() {
        if (connection == null) {
            connection = Persistence.createEntityManagerFactory("DatabaseConfig");
        }
        return connection;
    }

    public static void disconnect() {
        if (connection != null && connection.isOpen()) {
            connection.close();
        }
        connection = null;
    }
}
