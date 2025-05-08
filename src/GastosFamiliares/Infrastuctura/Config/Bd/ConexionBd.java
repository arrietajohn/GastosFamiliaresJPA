package GastosFamiliares.Infrastuctura.Config.Bd;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class ConexionBd {
    private static EntityManagerFactory conexion;
    
    public static EntityManagerFactory conectar(){
        if(conexion == null){
            conexion = Persistence.createEntityManagerFactory("ConfiguracionBd");
        }
        return conexion;
    }
    
    public static void desconectar(){
        if(conexion != null && conexion.isOpen()){
            conexion.close();
        }
        conexion = null;
    }
}
