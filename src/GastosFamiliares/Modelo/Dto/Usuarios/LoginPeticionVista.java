package GastosFamiliares.Modelo.Dto.Usuarios;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class LoginPeticionVista {
    
    private final String codigo;
    private final String password;
    
    public LoginPeticionVista(String codigo, String password){
        if(codigo == null || codigo.trim().isEmpty() ) {
            var mensaje = "El codigo es requerido";
            throw new IllegalArgumentException(mensaje);
        }
        if(password == null || password.trim().isEmpty() ) {
            var mensaje = "El pasword es requerido";
            throw new IllegalArgumentException(mensaje);
        }
        this.codigo = codigo;
        this.password = password;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getPassword() {
        return password;
    }
    
}
