package FamilyExpenses.Domain.Exceptions;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class EntityNotFoundException extends Exception {

    /**
     * Constructs an instance of <code>EntityNotFoundException</code> with the specified detail message.
     * @param message the detail message.
     */
    public EntityNotFoundException(String message) {
        super(message);
    }
}
