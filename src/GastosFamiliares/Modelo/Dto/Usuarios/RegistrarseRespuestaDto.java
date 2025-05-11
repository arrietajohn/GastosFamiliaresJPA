package GastosFamiliares.Modelo.Dto.Usuarios;

import GastosFamiliares.Modelo.Enumeraciones.RolUsuarioEnum;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class RegistrarseRespuestaDto {
    private final String codigo;
    private final String nombre;
    private final String apellido;
    private final RolUsuarioEnum rol;
    private final String email;
    private final String tipo;

    public RegistrarseRespuestaDto(String codigo, String nombre,
                                  String apellido, RolUsuarioEnum rol, 
                                  String email, String tipo) 
    {
        if(codigo == null || codigo.trim().isEmpty()){
            var mensaje = "El codigo es requerido";
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
        
        if(email == null || apellido.trim().isEmpty()){
            var mensaje = "El rol es requerido";
            throw new IllegalArgumentException(mensaje);
        }
        if(tipo == null || tipo.trim().isEmpty()){
            var mensaje = "El el tipo es requerido";
            throw new IllegalArgumentException(mensaje);
        }
     
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido= apellido;
        this.rol = rol;
        this.email= email;
        this.tipo  = tipo;
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

    public String getTipo() {
        return tipo;
    }
    
    
}
