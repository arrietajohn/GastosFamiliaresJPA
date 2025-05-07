package GastosFamiliares.Modelo.Entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class Gasto implements Serializable{
    private int id; // ' Autoincremental
    //    ' Fecha actual automatica 
    private LocalDateTime fechaRegistro; 
    private LocalDate fecha;
    private String nombre;
    private float valor;
    private String descripcion;
    //     ' Realaciones
    private Miembro miembro;
    private List<Categoria> categorias;
    private Aporte aporte; //' Puede ser null
    
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
                + miembro + ", categorias=" + (categorias != null ? categorias.size() : 0 )
                + ", aporte =" + aporte  + '}';
    }
    
    
}
