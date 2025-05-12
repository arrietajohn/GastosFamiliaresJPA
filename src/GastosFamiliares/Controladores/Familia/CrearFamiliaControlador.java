package GastosFamiliares.Controladores.Familia;

import GastosFamiliares.Modelo.CasosDeUso.Familia.CrearFamiliaCasoDeUso;
import GastosFamiliares.Modelo.Dto.Familia.CrearFamiliaPeticionDto;
import GastosFamiliares.Modelo.Dto.Familia.CrearFamiliaRespuestaDto;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class CrearFamiliaControlador {
    private final CrearFamiliaCasoDeUso casoDeUso;

    public CrearFamiliaControlador(CrearFamiliaCasoDeUso casoDeUso) {
        this.casoDeUso = casoDeUso;
    }
    
    public CrearFamiliaRespuestaDto ejecutarAccion(CrearFamiliaPeticionDto peticion) 
            throws Exception{
        return casoDeUso.procesar(peticion);
    }
}
