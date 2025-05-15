package FamilyExpenses.Domain.Exceptions;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class EntityAlreadyExistsException extends Exception {

    /**
     * Constructs a new EntityAlreadyExistsException with the specified detail message.
     * @param message the detail message.
     */
    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
