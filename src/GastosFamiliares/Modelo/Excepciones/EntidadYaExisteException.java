package GastosFamiliares.Modelo.Excepciones;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class EntidadYaExisteException extends Exception{
    public EntidadYaExisteException(String mensajeError){
        super(mensajeError);
    }
}
