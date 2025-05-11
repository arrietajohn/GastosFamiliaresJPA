package GastosFamiliares.Controladores.Usuario;

import GastosFamiliares.Modelo.CasosDeUso.Usuario.RegistrarseCasoDeUso;
import GastosFamiliares.Modelo.Dto.Usuarios.RegistrarsePeticionDto;
import GastosFamiliares.Modelo.Dto.Usuarios.RegistrarseRespuestaDto;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class RegistrarseControlador {

    private final RegistrarseCasoDeUso casoDeUso;

    public RegistrarseControlador(RegistrarseCasoDeUso casoDeUso) {
        this.casoDeUso = casoDeUso;
    }

    public RegistrarseRespuestaDto ejecutarAccion(RegistrarsePeticionDto peticion)
            throws Exception {
        return casoDeUso.procesar(peticion);
    }

}
