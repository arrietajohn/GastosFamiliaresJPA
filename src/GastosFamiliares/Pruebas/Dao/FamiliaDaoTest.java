package GastosFamiliares.Pruebas.Dao;

import GastosFamiliares.Infrastuctura.Dao.FamiliaDao;
import GastosFamiliares.Modelo.Entidades.Familia;
import GastosFamiliares.Modelo.Entidades.Usuario;
import GastosFamiliares.Modelo.Enumeraciones.RolUsuarioEnum;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class FamiliaDaoTest {
    public static void guardarFamiliaDebeGuardarLaFamiliaSinError(){
        // Arrange
        var usuario = new Usuario(
                "77788899", 
                "Abc**", 
                "John", 
                "Arrieta", 
                RolUsuarioEnum.USUARIO, 
                "");
       
        var familia = new Familia(
                "Arrieta Arrieta",
                 usuario);
        familia.setDireccion("Cartagena");
        familia.setEmail("farrietaarrieta@gmail.com");
        familia.setNumeroDeTelefono("301774455678");
        var familiaDao = new FamiliaDao();
        try {
            // Act
            familiaDao.guardar(familia);
             System.out.println("Familia creada, ID: "+familia.getId());
        } catch (Exception error) {
            System.err.println(error.getLocalizedMessage());
        }
        // Assert
       
    }
}
