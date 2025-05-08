package GastosFamiliares.Modelo.Entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
@Entity
@Table(name = "Fuentes")
public class Fuente implements Serializable {

    private static final long serialVersionUID = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    @Column(nullable = false, unique = true, length = 50)
    private String nombre; 
    private String descripcion;
    @Column(length = 20)
    private String icono;
    //    ' Relaciones
    @OneToMany(mappedBy = "fuente")
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
        int hash = 3;
        hash = 29 * hash + this.id;
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
        return Objects.equals(this.nombre, other.nombre);
    }

   
    @Override
    public String toString() {
        return "Fuente{" + "id=" + id + ", nombre=" + nombre + ", descripcion="
                + descripcion + ", icono=" + icono + ", ingresos=" + ingresos + '}';
    }

}
