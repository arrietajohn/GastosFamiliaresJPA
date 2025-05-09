/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GastosFamiliares.Modelo.Dao;

import GastosFamiliares.Infrastuctura.Config.Bd.ConexionBd;
import GastosFamiliares.Modelo.Entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author pc
 */
public class UsuarioDao {

    private EntityManagerFactory conexion;

    public UsuarioDao() {
        conexion = ConexionBd.conectar();
    }

    public void guardar(Usuario usuario) throws Exception {
        EntityTransaction transaccion = null;
        EntityManager entityManager = null;
        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            transaccion.begin();
            entityManager.persist(usuario);
            transaccion.commit();
        } catch (Exception error) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            var mesajeError = "Error al guardar el Usuario: " + usuario.getCodigo();
            throw new Exception(mesajeError);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public Usuario buscarPorId(String id) throws Exception {
        EntityManager entityManager = null;
        try {
            entityManager = conexion.createEntityManager();
            var usuario = entityManager.find(Usuario.class, id);
            if (usuario == null) {
                var mesajeError = "Error Usuario: " + id + " no existe";
                throw new Exception(mesajeError);
            }
            return usuario;
        } catch (Exception error) {
            throw error;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public List<Usuario> obtenerTodos() {
        var entityManager = conexion.createEntityManager();
        var consulta = "SELECT u FROM Usuario u";
        var listaUsuarios = entityManager.createQuery(consulta, Usuario.class).getResultList();
        entityManager.close();
        return listaUsuarios;
    }

    public void actualizar(Usuario usuario) throws Exception {
        this.buscarPorId(usuario.getCodigo());
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;
        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            transaccion.begin();
            entityManager.merge(usuario);
            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            var mesajeError = "Error al actualizar el Usuario: " + usuario.getCodigo();
            throw new Exception(mesajeError);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public void eliminarPorId(String id) throws Exception {
//        var usuario = this.buscarPorId(id);
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;
        try {
            entityManager = conexion.createEntityManager();
            var usuario = entityManager.find(Usuario.class, id);
            if(usuario == null){
                throw new Exception("Usuario ID: "+ id + " no existe");
            }
            transaccion = entityManager.getTransaction();
            transaccion.begin();
            entityManager.remove(usuario);
            transaccion.commit();
        } catch (Exception error) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            var mesajeError = "Error al eliminar el Usuario: " + id +"\n"
                    +error.getMessage();
            throw new Exception(mesajeError);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
