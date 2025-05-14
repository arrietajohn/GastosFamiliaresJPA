package GastosFamiliares.Infrastuctura.Dao;

import GastosFamiliares.Infrastuctura.Config.Bd.ConexionBd;
import GastosFamiliares.Modelo.Entidades.Miembro;
import GastosFamiliares.Modelo.Enumeraciones.RolUsuarioEnum;
import GastosFamiliares.Modelo.Excepciones.EntidadNoExisteException;
import GastosFamiliares.Modelo.Excepciones.EntidadYaExisteException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class MiembroDao {

    private final EntityManagerFactory conexionBd;

    public MiembroDao() {
        this.conexionBd = ConexionBd.conectar();
    }

    public void guardar(Miembro miembro) throws EntidadYaExisteException, Exception {
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;
        try {
            entityManager = conexionBd.createEntityManager();
            transaccion = entityManager.getTransaction();
            transaccion.begin();
            entityManager.merge(miembro);
            transaccion.commit();
        } catch (PersistenceException error) {
            var mensajeError = error.getMessage().toLowerCase();
            if(mensajeError.contains("duplicate") && mensajeError.contains("primary")){
                mensajeError = "Ya existe un Miembro con ID: "+miembro.getCodigo();
                throw new EntidadYaExisteException(mensajeError);
            }
            throw new Exception(mensajeError);
        } catch (Exception error) {
            throw new Exception("Error interno de bd al guardar miembro Id: " + miembro.getCodigo()+"\n"+error.getMessage());
        } finally {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }

    }

    public Miembro buscarPorId(String id) throws Exception {
        EntityManager entityManager = null;
        try {
            entityManager = conexionBd.createEntityManager();
            var miembro = entityManager.find(Miembro.class, id);
            if (miembro == null) {
                var mensajeError = "El miembro con ID: " + id + " no existe";
                throw new EntidadNoExisteException(mensajeError);
            }
            return miembro;
        } catch (EntidadNoExisteException e) {
            throw e;
        } catch (Exception error) {
            var mensajeError = "Error interno de BD al consultar usuario con ID: " + id;
            throw new Exception(mensajeError);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public void actualizar(Miembro miembro) throws Exception {
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;
        try {
            entityManager = conexionBd.createEntityManager();
            if (entityManager.find(Miembro.class, miembro.getCodigo()) == null) {
                var mensajeError = "El miembro con Id: " + miembro.getCodigo() + " no existe";
                throw new EntidadNoExisteException(mensajeError);
            }
            transaccion = entityManager.getTransaction();
            transaccion.begin();
            entityManager.persist(miembro);
            transaccion.commit();
        } catch (EntidadNoExisteException e) {
            throw e;
        } catch (Exception e) {
            var mensajeError = "Error interno de BD al actualizar el miembro ID: " + miembro.getCodigo();
            throw new Exception(mensajeError);
        } finally {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public void eliminar(String id) throws Exception {
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;
        try {
            entityManager = conexionBd.createEntityManager();
            var miembro = entityManager.find(Miembro.class, id);
            if (miembro == null) {
                var mensajeError = "El miembro con Id: " + id + " no existe";
                throw new EntidadNoExisteException(mensajeError);
            }
            transaccion = entityManager.getTransaction();
            transaccion.begin();
            entityManager.remove(miembro);
            transaccion.commit();
        } catch (EntidadNoExisteException e) {
            throw e;
        } catch (Exception e) {
            var mensajeError = "Error interno de BD al actualizar el miembro ID: " + id;
            throw new Exception(mensajeError);
        } finally {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }

    }

    public List<Miembro> obtenerTodo() throws Exception {
        var consulta = "SELECT u FROM Miembro u";

        EntityManager entityManager = null;
        try {
            entityManager = conexionBd.createEntityManager();
            return entityManager.createQuery(consulta, Miembro.class).getResultList();
        } catch (Exception e) {
            var mensajeError = "Error interno de Bd al obtener todos los Miembros";
            throw new Exception(mensajeError);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public long contar() throws Exception {
        EntityManager entityManager = null;
        try {
            entityManager = conexionBd.createEntityManager();
            return entityManager.createQuery("SELECT COUNT(m) FROM Miembro m", Long.class).
                    getSingleResult();
        } catch (Exception error) {
            var mensajeError = "Error interno de BD durante el conteo de Miembro";
            throw new Exception(mensajeError);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }


}
