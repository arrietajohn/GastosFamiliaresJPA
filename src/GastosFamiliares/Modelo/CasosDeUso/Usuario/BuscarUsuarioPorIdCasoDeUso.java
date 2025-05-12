package GastosFamiliares.Modelo.CasosDeUso.Usuario;

import GastosFamiliares.Infrastuctura.Dao.UsuarioDao;
import GastosFamiliares.Modelo.Dto.Usuarios.BuscarUsuarioPorIdPeticionDto;
import GastosFamiliares.Modelo.Dto.Usuarios.BuscarUsuarioPorIdRespuestaDto;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class BuscarUsuarioPorIdCasoDeUso {

    private final UsuarioDao usuarioDao;

    public BuscarUsuarioPorIdCasoDeUso(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public BuscarUsuarioPorIdRespuestaDto procesar(
            BuscarUsuarioPorIdPeticionDto peticion) throws Exception {

        try {
            var usuario = usuarioDao.buscarPorId(peticion.getCodigo());
            var respuesta = new BuscarUsuarioPorIdRespuestaDto(
                    usuario.getCodigo(),
                    usuario.getPassword(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getRol(),
                    usuario.getEmail());
            return respuesta;
        } catch (Exception error) {
           var mensaje = "No puede consultar el usuario\n" + error.getMessage();
           throw new Exception(mensaje);
        }
       
    }
}
