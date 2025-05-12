package GastosFamiliares.Controladores.Usuario;

import GastosFamiliares.Modelo.CasosDeUso.Usuario.EditarUsuarioCasoDeUso;
import GastosFamiliares.Modelo.Dto.Usuarios.EditarUsuarioPeticionDto;
import GastosFamiliares.Modelo.Dto.Usuarios.EditarUsuarioRespuestDto;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class EditarUsuarioControlador {
    private final EditarUsuarioCasoDeUso casoDeUso;

    public EditarUsuarioControlador(EditarUsuarioCasoDeUso casoDeUso) {
        this.casoDeUso = casoDeUso;
    }
    
    public EditarUsuarioRespuestDto ejecutarAccion(EditarUsuarioPeticionDto peticion)
            throws Exception
    {
        return casoDeUso.procesar(peticion);
    }
}
