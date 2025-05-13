package GastosFamiliares.Pruebas.Dao;

import GastosFamiliares.Infrastuctura.Dao.UsuarioDao;
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
                "U-1",
                "!23Abc$$",
                "Fulanito1",
                "De tal",
                RolUsuarioEnum.USUARIO,
                "fulanito1@gmail.com");
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

    public static void listarTodosLosUsuarioDebeMostarSusDatos() {
        // Arrenge (Preparar)
        var usuarioDao = new UsuarioDao();
        // Act (Actuar)
        var usuarios = usuarioDao.obtenerTodos();
        // Assert (Verificar)
        for (var usuario : usuarios) {
            System.out.println("--------------");
            System.out.println(usuario);
        }
        if (usuarios.isEmpty()) {
            System.out.println("No existen usuarios en el sistema");
        }
    }

    public static void actualizarUsuarioDebeActualizarSinError() {
        // Arrange
        var usuario = new Usuario(
                "U-7",
                "XXYYZZ...",
                "FulanitoXyz",
                "De tal",
                RolUsuarioEnum.USUARIO,
                "fulanitoyxz@gmail.com");
        var usuarioDao = new UsuarioDao();

        try {
            // Act
            usuarioDao.actualizar(usuario);
            // Assert
            System.out.println("Usuario actualizado");
        } catch (Exception error) {
            // Assert
            System.err.println(error.getMessage());

        }
    }
    
    public static void eliminarUsuarioDebeEliminarSinError(){
        // Arrange
        var id = "U-1";
        var usuarioDao = new UsuarioDao();
        try {
            // Act
            usuarioDao.eliminarPorId(id);
            // Assert
            System.out.println("Usuario Elimiando");
        } catch (Exception error) {
            // Assert
            System.err.println(error.getMessage());
        }  
    }
}
