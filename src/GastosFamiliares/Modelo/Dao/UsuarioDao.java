/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GastosFamiliares.Modelo.Dao;

import GastosFamiliares.Infrastuctura.Config.Bd.ConexionBd;
import GastosFamiliares.Modelo.Entidades.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author pc
 */
public class UsuarioDao {
    private EntityManagerFactory conexion;
    
    public UsuarioDao(){
        conexion = ConexionBd.conectar();
    }
    
    public void guardar(Usuario usuario) throws Exception {
        EntityTransaction transaccion = null;
        EntityManager entityManager = null;
        try{
           entityManager = conexion.createEntityManager();
           transaccion = entityManager.getTransaction();
           transaccion.begin();
           entityManager.persist(usuario);
           transaccion.commit();
        }catch(Exception error){
            if(transaccion != null && transaccion.isActive() ){
                transaccion.rollback();
            }
            var mesajeError = "Error al guardar el Usuario: "+usuario.getCodigo();
            throw new Exception(mesajeError);
        }
        finally{
            if(entityManager != null && entityManager.isOpen()){
                 entityManager.close();
            }
        }
    }
    
    public Usuario buscarPorId(String id) throws Exception {
         EntityManager entityManager = null;
        try{
           entityManager = conexion.createEntityManager();
          var usuario = entityManager.find(Usuario.class, id);
          if(usuario == null){
            var mesajeError = "Error Usuario: "+id + " no existe";
            throw new Exception(mesajeError);
          }
          return usuario;
        }catch(Exception error){
            throw error;
        }
        finally{
            if(entityManager != null && entityManager.isOpen()){
                 entityManager.close();
            }
        }
    }
}
