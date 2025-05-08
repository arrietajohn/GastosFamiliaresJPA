package GastosFamiliares.Modelo.Entidades;

import GastosFamiliares.Modelo.Enumeraciones.RolUsuarioEnum;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
/**
 *
 * @author John Carlos Arrieta Arrieta
 */
@Entity(name = "Usuarios")
public class Usuario implements Serializable {
    @Id
    @Column(name = "ID", length = 20 )
    protected String codigo; 
    @Column(length = 30, nullable = false)
    protected String password;
    @Column(length = 40, nullable = false)
    protected String nombre;
    @Column(length = 50, nullable = false)
    protected String apellido;
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    protected RolUsuarioEnum rol; 
    @Column(length = 70, nullable = false, unique = true)
    protected String email;
    
    // Constructor por defecto
    public Usuario(){
        
    }
    
    // Constructores con parametros
    
    public Usuario(String id, String nombre, String apellido, RolUsuarioEnum rol){
        codigo = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
    }

    public Usuario(String codigo, String password, String nombre, String apellido, RolUsuarioEnum rol, String email) {
        this.codigo = codigo;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.email = email;
    }
    
    
    
    // Set y get
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    public String getCodigo( ){
        return this.codigo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public RolUsuarioEnum getRol() {
        return rol;
    }

    public void setRol(RolUsuarioEnum rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", password=" + password + 
                ", nombre=" + nombre + ", apellido=" + apellido + ", rol=" 
                + rol + ", email=" + email + '}';
    }
    
    
    
    
}
