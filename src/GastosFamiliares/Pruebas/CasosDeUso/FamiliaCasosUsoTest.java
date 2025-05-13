package GastosFamiliares.Pruebas.CasosDeUso;

import GastosFamiliares.Infrastuctura.Dao.FamiliaDao;
import GastosFamiliares.Infrastuctura.Dao.UsuarioDao;
import GastosFamiliares.Modelo.CasosDeUso.Familia.CrearFamiliaCasoDeUso;
import GastosFamiliares.Modelo.Dto.Familia.CrearFamiliaPeticionDto;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class FamiliaCasosUsoTest {
    public static void crearFamiliaDebeGuardalaSinError(){
        try {
            // Arrange
            var usuarioId = "U-1";
            var nombre = "Familia Villareal";
            var email = "farrietavillarreal@hotmail.com";
            var numeroTelefonico = "6784748";
            var direccion = "Cartagena";
            var peticion = new CrearFamiliaPeticionDto(
                    nombre,
                    usuarioId,
                    direccion,
                    email,
                    numeroTelefonico);
            var familiaDao = new FamiliaDao();
            var usuarioDao = new UsuarioDao();
            var casoUso = new CrearFamiliaCasoDeUso(familiaDao, usuarioDao);
            // Act
            var respuesta = casoUso.procesar(peticion);
            // Assert
            System.out.println("Familia Creada, Id: "+respuesta.getFamiliaId());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
