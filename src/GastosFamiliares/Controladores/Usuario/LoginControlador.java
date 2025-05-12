package GastosFamiliares.Controladores.Usuario;

import GastosFamiliares.Modelo.CasosDeUso.Usuario.LoginCasoDeUso;
import GastosFamiliares.Modelo.Dto.Usuarios.LoginPeticionDto;
import GastosFamiliares.Modelo.Dto.Usuarios.LoginRespuestaDto;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class LoginControlador {

    private final LoginCasoDeUso loginCasoDeUso;
    
    public LoginControlador(LoginCasoDeUso casoDeUso){
        this.loginCasoDeUso = casoDeUso;
    }
    
    public LoginRespuestaDto ejecutarAccion(LoginPeticionDto peticion) throws Exception{
        return loginCasoDeUso.procesar(peticion);
    }
}
