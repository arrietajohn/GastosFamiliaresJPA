package GastosFamiliares.Modelo.CasosDeUso.Usuario;

import GastosFamiliares.Infrastuctura.Dao.UsuarioDao;
import GastosFamiliares.Modelo.Dto.Usuarios.EditarUsuarioPeticionDto;
import GastosFamiliares.Modelo.Dto.Usuarios.EditarUsuarioRespuestDto;
import GastosFamiliares.Modelo.Entidades.Usuario;
import GastosFamiliares.Modelo.Enumeraciones.RolUsuarioEnum;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class EditarUsuarioCasoDeUso {
    private final UsuarioDao usuarioDao;

    public EditarUsuarioCasoDeUso(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
    
    public EditarUsuarioRespuestDto procesar(EditarUsuarioPeticionDto peticion) 
            throws Exception
    {
        
        try {
            var usuario = new Usuario(
                    peticion.getCodigo(),
                    peticion.getPassword(),
                    peticion.getNombre(),
                    peticion.getApellido(),
                    peticion.getRol(),
                    peticion.getEmail());
            usuarioDao.actualizar(usuario);
            return  new EditarUsuarioRespuestDto(
                    usuario.getCodigo(),
                    usuario.getPassword(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getRol(),
                    usuario.getEmail());
        } catch (Exception error) {
            var mensaje = "No fue posible actualizar el Usuario\n" 
                    + error.getMessage();
            throw new Exception(mensaje);
        }

    }
}