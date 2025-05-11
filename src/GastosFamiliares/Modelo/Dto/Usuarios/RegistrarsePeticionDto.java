package GastosFamiliares.Modelo.Dto.Usuarios;

import GastosFamiliares.Modelo.Enumeraciones.RolUsuarioEnum;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class RegistrarsePeticionDto {

    private final String codigo;
    private final String password;
    private final String nombre;
    private final String apellido;
    private final RolUsuarioEnum rol;
    private final String email;

    public RegistrarsePeticionDto(String codigo, String password, String nombre,
                                  String apellido, RolUsuarioEnum rol, 
                                  String email) 
    {
        if(codigo == null || codigo.trim().isEmpty()){
            var mensaje = "El codigo es requerido";
            throw new IllegalArgumentException(mensaje);
        }
        
        if(password == null || password.trim().isEmpty()){
            var mensaje = "El password es requerido";
            throw new IllegalArgumentException(mensaje);
        }
        
        if(nombre == null || nombre.trim().isEmpty()){
            var mensaje = "El nombre es requerido";
            throw new IllegalArgumentException(mensaje);
        }
        
        if(apellido == null || apellido.trim().isEmpty()){
            var mensaje = "El apellido es requerido";
            throw new IllegalArgumentException(mensaje);
        }
        
        if(rol == null){
            var mensaje = "El rol es requerido";
            throw new IllegalArgumentException(mensaje);
        }
        
        if(email == null || email.trim().isEmpty()){
            var mensaje = "El email es requerido";
            throw new IllegalArgumentException(mensaje);
        }
        
        this.codigo = codigo;
        this.password = password;
        this.nombre = nombre;
        this.apellido= apellido;
        this.rol = rol;
        this.email= email;
   }

    public String getCodigo() {
        return codigo;
    }

    public String getPassword() {
        return password;
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
