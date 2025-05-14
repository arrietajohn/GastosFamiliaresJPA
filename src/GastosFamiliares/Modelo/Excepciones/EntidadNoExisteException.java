package GastosFamiliares.Modelo.Excepciones;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class EntidadNoExisteException extends Exception {

    /**
     * Constructs an instance of <code>EntidadNoExisteException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EntidadNoExisteException(String msg) {
        super(msg);
    }
}
