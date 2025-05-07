package GastosFamiliares.Modelo.Entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class Categoria implements Serializable{

    private int id; // ' Autoincremental
    private String nombre; // 'unico
    private String descripcion;
    private String icono;
//    ' Realaciones
    private List<Gasto> gastos;
    
    // Constructores

    public Categoria() {
    }

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    
    public Categoria(int id, String nombre, String descripcion, String icono, List<Gasto> gastos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.icono = icono;
        this.gastos = gastos;
    }
    
    
    // Set y get 

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
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
        final Categoria other = (Categoria) obj;
        return Objects.equals(this.nombre.toLowerCase(), other.nombre.toLowerCase());
    }

  
    
    
}
