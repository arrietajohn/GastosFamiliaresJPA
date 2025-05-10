package GastosFamiliares.Modelo.Dto.Usuarios;

import GastosFamiliares.Modelo.Enumeraciones.RolUsuarioEnum;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class LoginRespuestaVista {
    private final String codigo;
    private final String nombre;
    private final String apellido;
    private final RolUsuarioEnum rol;
    private final String email;


    public LoginRespuestaVista(String codigo, String nombre, String apellido, RolUsuarioEnum rol, String email) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public RolUsuarioEnum getRol() {
        return rol;
    }

    public String getEmail() {
        return email;
    }
    
    
}
