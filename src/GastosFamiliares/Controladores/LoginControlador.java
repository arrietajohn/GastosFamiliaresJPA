package GastosFamiliares.Controladores;

import GastosFamiliares.Modelo.CasosDeUso.LoginCasoDeUso;
import GastosFamiliares.Modelo.Dto.Usuarios.LoginPeticionVista;
import GastosFamiliares.Modelo.Dto.Usuarios.LoginRespuestaVista;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class LoginControlador {

    private final LoginCasoDeUso loginCasoDeUso;
    
    public LoginControlador(LoginCasoDeUso casoDeUso){
        this.loginCasoDeUso = casoDeUso;
    }
    
    public LoginRespuestaVista ejecutarAccion(LoginPeticionVista peticion) throws Exception{
        return loginCasoDeUso.procesar(peticion);
    }
}
