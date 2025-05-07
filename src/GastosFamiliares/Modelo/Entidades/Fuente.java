package GastosFamiliares.Modelo.Entidades;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class Fuente implements Serializable{

    private int id; //' Autoincremental
    private String nombre; // 'unico
    private String descripcion;
    private String icono;
    //    ' Relaciones
    private List<Ingreso> ingresos;
    
    // Constructores

    public Fuente() {
    }

    public Fuente(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Fuente(int id, String nombre, String descripcion, String icono, List<Ingreso> ingresos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.icono = icono;
        this.ingresos = ingresos;
    }
    
    // Set y Get

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

    public List<Ingreso> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<Ingreso> ingresos) {
        this.ingresos = ingresos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
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
        final Fuente other = (Fuente) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Fuente{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" 
                + descripcion + ", icono=" + icono + ", ingresos=" + ingresos + '}';
    }
    
    
    
}
