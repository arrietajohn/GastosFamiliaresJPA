package GastosFamiliares.Modelo.Entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
@Entity
@Table(name = "Gastos")
public class Gasto implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //    ' Fecha actual automatica 
    private LocalDateTime fechaRegistro;
    private LocalDate fecha;
    @Column(length = 50, nullable = false)
    private String nombre;
    @Column(nullable = false)
    private float valor;
    private String descripcion;
    //     ' Realaciones
    @ManyToOne
    private Miembro miembro;
    @ManyToOne(optional = true)
    @JoinColumn(nullable = true)
    private Aporte aporte; 
    @ManyToMany
    @JoinTable(
        name = "Categorias_Gastos",
        joinColumns = @JoinColumn(name = "GASTO_ID"),
        inverseJoinColumns = @JoinColumn(name = "CATEGORIA_ID")
    )
    private List<Categoria> categorias;
    

    // Constructores
    public Gasto() {
    }

    public Gasto(LocalDate fecha, String nombre, float valor, Miembro miembro) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.valor = valor;
        this.miembro = miembro;
    }

    public Gasto(int id, LocalDateTime fechaRegistro, LocalDate fecha, String nombre, float valor, String descripcion, Miembro miembro, List<Categoria> categorias, Aporte aporte) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
        this.fecha = fecha;
        this.nombre = nombre;
        this.valor = valor;
        this.descripcion = descripcion;
        this.miembro = miembro;
        this.categorias = categorias;
        this.aporte = aporte;
    }

    // Set y get
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void setAporte(Aporte aporte) {
        this.aporte = aporte;
    }

    public Aporte getAporte() {
        return aporte;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
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
        final Gasto other = (Gasto) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Gasto{" + "id=" + id + ", fechaRegistro=" + fechaRegistro
                + ", fecha=" + fecha + ", nombre=" + nombre + ", valor="
                + valor + ", descripcion=" + descripcion + ", miembro="
                + miembro + ", categorias=" + (categorias != null ? categorias.size() : 0)
                + ", aporte =" + aporte + '}';
    }

}
