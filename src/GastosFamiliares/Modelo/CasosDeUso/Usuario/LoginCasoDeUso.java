package GastosFamiliares.Modelo.CasosDeUso.Usuario;

import GastosFamiliares.Infrastuctura.Dao.UsuarioDao;
import GastosFamiliares.Modelo.Dto.Usuarios.LoginPeticionVista;
import GastosFamiliares.Modelo.Dto.Usuarios.LoginRespuestaVista;
import GastosFamiliares.Modelo.Entidades.Usuario;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class LoginCasoDeUso {

    private final UsuarioDao usuarioDao;
    public LoginCasoDeUso(UsuarioDao usuarioDao){
        this.usuarioDao = usuarioDao;
    }
    public LoginRespuestaVista procesar(LoginPeticionVista peticion ) throws Exception{
        try {
            Usuario usuario = usuarioDao.buscarPorId(peticion.getCodigo());
            if(! usuario.getPassword().equals(peticion.getPassword())){
                throw new Exception("No autorizado");
            }
            return new LoginRespuestaVista(
                    usuario.getCodigo(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getRol(),
                    usuario.getEmail());
        } catch (Exception error) {
           throw error;
        }
    }
}
