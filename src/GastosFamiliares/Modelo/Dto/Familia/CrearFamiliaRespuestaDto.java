package GastosFamiliares.Modelo.Dto.Familia;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class CrearFamiliaRespuestaDto {
    private final int familiaId;

    public CrearFamiliaRespuestaDto(int familiaId) {
        this.familiaId = familiaId;
    }

    public int getFamiliaId() {
        return familiaId;
    }
    
    
}
