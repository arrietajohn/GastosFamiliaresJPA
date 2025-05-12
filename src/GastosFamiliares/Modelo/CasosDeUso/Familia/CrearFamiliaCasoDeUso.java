package GastosFamiliares.Modelo.CasosDeUso.Familia;

import GastosFamiliares.Infrastuctura.Dao.UsuarioDao;
import GastosFamiliares.Infrastuctura.Dao.FamiliaDao;
import GastosFamiliares.Modelo.Dto.Familia.CrearFamiliaPeticionDto;
import GastosFamiliares.Modelo.Dto.Familia.CrearFamiliaRespuestaDto;
import GastosFamiliares.Modelo.Entidades.Familia;
import GastosFamiliares.Modelo.Enumeraciones.RolUsuarioEnum;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class CrearFamiliaCasoDeUso {

    private final FamiliaDao familiaDao;
    private final UsuarioDao usuarioDao;
//    private final MiembroDao miembroDao;

    public CrearFamiliaCasoDeUso(FamiliaDao familiaDao, UsuarioDao usuarioDao) {
        this.familiaDao = familiaDao;
        this.usuarioDao = usuarioDao;
    }
    
    public CrearFamiliaRespuestaDto procesar(CrearFamiliaPeticionDto peticion) 
            throws Exception{
        try {
            // validar si el usuario creador existe
            var usuarioCreador = usuarioDao.buscarPorId(peticion.getUsuarioId());
            // mapear el objeto peticion a objeto Famialia
            var nuevaFamilia = new Familia(peticion.getNombre(), usuarioCreador);
            nuevaFamilia.setEmail(peticion.getEmail());
            nuevaFamilia.setNumeroDeTelefono(peticion.getNumeroTelefonico());
            nuevaFamilia.setDireccion(peticion.getDireccion());
            // guardar el objeto familia
            familiaDao.guardar(nuevaFamilia);
            // validar si el usuario ya es o no un Miembeo
            if(usuarioCreador.getRol()== RolUsuarioEnum.USUARIO){
                // --- Crear el objeto miembro a partir del objeto usuario
                // Pendiente crear el usuario creador como un usuario Miembro
            }
            // retornar el ID de la nueva familia
            
            return new CrearFamiliaRespuestaDto(nuevaFamilia.getId());
        } catch (Exception error) {
            var mensaje = "No fue posible guardar la nueva familia\n"+
                    error.getMessage();
            throw new Exception(mensaje);
          
        }
    }
    
    
}
