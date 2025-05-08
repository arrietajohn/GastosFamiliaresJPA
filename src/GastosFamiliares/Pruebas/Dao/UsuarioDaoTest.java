package GastosFamiliares.Pruebas.Dao;

import GastosFamiliares.Modelo.Dao.UsuarioDao;
import GastosFamiliares.Modelo.Entidades.Usuario;
import GastosFamiliares.Modelo.Enumeraciones.RolUsuarioEnum;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class UsuarioDaoTest {

    // A A A
    public static void crearNuevoUsuarioDebeGuardarSinError() {
        // Arrange (Preparar)
        var usuario = new Usuario(
                "U-2",
                "!23Abc$$",
                "Fulanito2",
                "De tal",
                RolUsuarioEnum.USUARIO,
                "fulanito2@gmail.com");
        try {
            var usuarioDao = new UsuarioDao();
            // Act (Actuar)
            usuarioDao.guardar(usuario);
            // Assert
            System.out.println("Usuario Guardado, Codigo: " + usuario.getCodigo());
        } catch (Exception error) {
            // Assert
            System.err.println(error.getMessage());
        }
    }
    
    public static void buscarUsuarioPorIdDebeMostrarLosDatosDelUsuario() {
        // Arrange (Preparar)
        var id = "U-1";
        try {
            var usuarioDao = new UsuarioDao();
            // Act (Actuar)
            var usuario = usuarioDao.buscarPorId(id);
            // Assert
            System.out.println(usuario);
        } catch (Exception error) {
            // Assert
            System.err.println(error.getMessage());
        }
    }
}
