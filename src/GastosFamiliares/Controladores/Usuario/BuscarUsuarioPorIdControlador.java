package GastosFamiliares.Controladores.Usuario;

import GastosFamiliares.Modelo.CasosDeUso.Usuario.BuscarUsuarioPorIdCasoDeUso;
import GastosFamiliares.Modelo.Dto.Usuarios.BuscarUsuarioPorIdPeticionDto;
import GastosFamiliares.Modelo.Dto.Usuarios.BuscarUsuarioPorIdRespuestaDto;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class BuscarUsuarioPorIdControlador {
    private final BuscarUsuarioPorIdCasoDeUso casoDeUso;

    public BuscarUsuarioPorIdControlador(BuscarUsuarioPorIdCasoDeUso casoDeUso) 
    {
        this.casoDeUso = casoDeUso;
    }
    
    public BuscarUsuarioPorIdRespuestaDto ejecutarAccion(
                        BuscarUsuarioPorIdPeticionDto peticion) throws Exception
    {
        return casoDeUso.procesar(peticion);
    }
}
