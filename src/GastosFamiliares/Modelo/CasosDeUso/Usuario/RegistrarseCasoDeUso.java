package GastosFamiliares.Modelo.CasosDeUso.Usuario;

import GastosFamiliares.Infrastuctura.Dao.UsuarioDao;
import GastosFamiliares.Modelo.Dto.Usuarios.RegistrarsePeticionDto;
import GastosFamiliares.Modelo.Dto.Usuarios.RegistrarseRespuestaDto;
import GastosFamiliares.Modelo.Entidades.Usuario;
import GastosFamiliares.Modelo.Enumeraciones.RolUsuarioEnum;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class RegistrarseCasoDeUso {

    private final UsuarioDao usuarioDao;
    // private final ServicioEmail email;

    public RegistrarseCasoDeUso(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public RegistrarseRespuestaDto procesar(RegistrarsePeticionDto peticion) 
            throws Exception {
        try {
            var usuario = new Usuario(
                    peticion.getCodigo(),
                    peticion.getPassword(),
                    peticion.getNombre(),
                    peticion.getApellido(),
                    peticion.getRol(),
                    peticion.getEmail());

            usuarioDao.guardar(usuario);
            // servicioEmail.enviar(peticion);
            return  new RegistrarseRespuestaDto(
                    usuario.getCodigo(), 
                    usuario.getNombre(), 
                    usuario.getApellido(), 
                    usuario.getRol(), 
                    usuario.getEmail(), 
                    usuario.getRol().toString());
        } catch (Exception error) {
            var mensaje = "No fue pisible registrar el usuario\n" + error.getMessage();
            throw new Exception(mensaje);
        }

    }

}
