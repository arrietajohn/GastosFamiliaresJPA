package GastosFamiliares.Modelo.Dto.Familia;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class CrearFamiliaPeticionDto {
    private final String nombre;
    private final String usuarioId;
    private final String direccion;
    private final String email;
    private final String numeroTelefonico;

    public CrearFamiliaPeticionDto(String nombre, String usuarioId, String direccion, String email, String numeroTelefonico) {
        if(nombre == null || nombre.trim().isEmpty() ){
            throw new IllegalArgumentException("El nombre es requerido");
        }
        if(usuarioId == null || usuarioId.trim().isEmpty() ){
            throw new IllegalArgumentException("El usuario creador es requerido");
        }
        this.nombre = nombre;
        this.usuarioId = usuarioId;
        this.direccion = direccion;
        this.email = email;
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }
    
    
    
}
