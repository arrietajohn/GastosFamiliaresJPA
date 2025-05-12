package GastosFamiliares.Modelo.Dto.Usuarios;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class BuscarUsuarioPorIdPeticionDto {

    private final String codigo;
    
    public BuscarUsuarioPorIdPeticionDto(String codigo){
        if(codigo == null || codigo.trim().isEmpty()){
            throw new IllegalArgumentException("El codigo es requerido");
        }
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
    
    
}
