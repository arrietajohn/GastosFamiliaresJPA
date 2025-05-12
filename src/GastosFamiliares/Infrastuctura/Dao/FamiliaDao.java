package GastosFamiliares.Infrastuctura.Dao;

import GastosFamiliares.Infrastuctura.Config.Bd.ConexionBd;
import GastosFamiliares.Modelo.Entidades.Familia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class FamiliaDao {
    private final EntityManagerFactory conexionBd;

    public FamiliaDao() {
        this.conexionBd = ConexionBd.conectar() ;
    }
    
    public void guardar(Familia familia) throws Exception{
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;
        try {
            entityManager = conexionBd.createEntityManager();
            transaccion = entityManager.getTransaction();
            transaccion.begin();
            entityManager.persist(familia);
            transaccion.commit();
        } catch (Exception error) {
            if(transaccion != null && transaccion.isActive()){
                transaccion.rollback();
            }
            var mensaje = "Error al guardar la Familia.";
            throw new Exception(mensaje);
            
        } finally {
            if(entityManager != null && entityManager.isOpen()){
                entityManager.close();
                entityManager = null;
            }
        }
    } 
    
    
}
