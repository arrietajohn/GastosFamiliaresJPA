package GastosFamiliares.Modelo.Entidades;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class Familia implements Serializable{
    private int id; // ' Autoincremental
    private String nombre;
    private Usuario creador;
    private String direccion;
    private String numeroDeTelefono;  
    private String email;
//    ' Relaciones
    private List<Miembro> miembros;
    private List<BolsaDeAhorro> bolsasDeAhorros;
    
    // Constructores

    public Familia() {
    }

    public Familia(String nombre, Usuario creador) {
        this.nombre = nombre;
        this.creador = creador;
    }

    public Familia(int id, String nombre, Usuario creador, String direccion, String numeroDeTelefono, String email, List<Miembro> miembros, List<BolsaDeAhorro> bolsasDeAhorros) {
        this.id = id;
        this.nombre = nombre;
        this.creador = creador;
        this.direccion = direccion;
        this.numeroDeTelefono = numeroDeTelefono;
        this.email = email;
        this.miembros = miembros;
        this.bolsasDeAhorros = bolsasDeAhorros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<Miembro> miembros) {
        this.miembros = miembros;
    }

    public List<BolsaDeAhorro> getBolsasDeAhorros() {
        return bolsasDeAhorros;
    }

    public void setBolsasDeAhorros(List<BolsaDeAhorro> bolsasDeAhorros) {
        this.bolsasDeAhorros = bolsasDeAhorros;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
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
        final Familia other = (Familia) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Familia{" + "id=" + id + ", nombre=" + nombre + ", creador=" 
                + creador + ", direccion=" + direccion + ", numeroDeTelefono=" 
                + numeroDeTelefono + ", email=" + email + ", miembros=" 
                + miembros + ", bolsasDeAhorros=" + bolsasDeAhorros + '}';
    }
    
    
}
