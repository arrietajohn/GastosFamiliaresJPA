package GastosFamiliares;

import GastosFamiliares.Infrastuctura.Config.Bd.ConexionBd;
import GastosFamiliares.Infrastuctura.Dao.FamiliaDao;
import GastosFamiliares.Infrastuctura.Dao.UsuarioDao;
import GastosFamiliares.Pruebas.Dao.FamiliaDaoTest;
import GastosFamiliares.Pruebas.Dao.UsuarioDaoTest;
import GastosFamiliares.Vistas.Gui.VentanaPrincipal;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class Principal {

    public static void main(String parametros[]) {
        System.out.println("Prueba del proyecto");
//        FamiliaDaoTest.guardarFamiliaDebeGuardarLaFamiliaSinError();
        UsuarioDaoTest.crearNuevoUsuarioDebeGuardarSinError();
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
        ventana.setVisible(true);
//        
    }
}
