package GastosFamiliares.Pruebas.Dao;

import GastosFamiliares.Infrastuctura.Dao.MiembroDao;
import GastosFamiliares.Modelo.Entidades.Familia;
import GastosFamiliares.Modelo.Entidades.Miembro;
import GastosFamiliares.Modelo.Entidades.Usuario;
import GastosFamiliares.Modelo.Enumeraciones.GeneroEnum;
import GastosFamiliares.Modelo.Enumeraciones.RolFamiliaEnum;
import GastosFamiliares.Modelo.Enumeraciones.RolUsuarioEnum;
import java.time.LocalDate;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class MiembroDaoTest {

    public static void guardarMiembroDebeGuardarloSinErrores() {
        try {
            var usuario = new Usuario("U-1", "Fulanito1", "De tal", RolUsuarioEnum.USUARIO);
            usuario.setEmail("fulanito1@gmail.com");
            usuario.setPassword("Abc**");
            var familia = new Familia(1,
                    "Arrieta Villarreal", usuario, "Cartagena", "12334", "farrietavillareal@gmail.com", null, null);
            var nuevoMiembro = new Miembro(usuario,
                    "Primero",
                    "Pascual",
                    GeneroEnum.MASCULINO,
                    LocalDate.now().minusYears(47),
                    "Desarrollador",
                    familia);
            nuevoMiembro.setRolFamilia(RolFamiliaEnum.PADRE);
            nuevoMiembro.setNumeroTelefonico("234234");
   
            var miembroDao = new MiembroDao();
        // Act
            miembroDao.guardar(nuevoMiembro);
         // Assert 
            System.out.println("Miembro guardado");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());;
        }

    }
}
