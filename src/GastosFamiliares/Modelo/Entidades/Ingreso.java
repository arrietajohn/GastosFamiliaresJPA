package GastosFamiliares.Modelo.Entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class Ingreso implements  Serializable{

    private int id; //' Autoincremental
    //    ' Fecha actual automatica 
    private LocalDateTime fechaRegistro;
    private LocalDate fecha;
    private String nombre;
    private float valor;
    private String descripcion;
    //     ' Realaciones
    private Fuente fuente;
    private Miembro miembro;
    private List<Aporte> aportes; //' Puede ser null
    
    // Constructores

    public Ingreso() {
    }

    public Ingreso(LocalDate fecha, String nombre, float valor, Fuente fuente, Miembro miembro) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.valor = valor;
        this.fuente = fuente;
        this.miembro = miembro;
    }

    
    public Ingreso(int id, LocalDateTime fechaRegistro, LocalDate fecha, String nombre, float valor, String descripcion, Fuente fuente, Miembro miembro, List<Aporte> aportes) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
        this.fecha = fecha;
        this.nombre = nombre;
        this.valor = valor;
        this.descripcion = descripcion;
        this.fuente = fuente;
        this.miembro = miembro;
        this.aportes = aportes;
    }
    
    // Set y Get

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

    public Fuente getFuente() {
        return fuente;
    }

    public void setFuente(Fuente fuente) {
        this.fuente = fuente;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    public List<Aporte> getAportes() {
        return aportes;
    }

    public void setAportes(List<Aporte> aportes) {
        this.aportes = aportes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
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
        final Ingreso other = (Ingreso) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Ingreso{" + "id=" + id + ", fechaRegistro=" + fechaRegistro + 
                ", fecha=" + fecha + ", nombre=" + nombre + ", valor=" + valor 
                + ", descripcion=" + descripcion + ", fuente=" + fuente +
                ", miembro=" + miembro + ", aportes=" + aportes + '}';
    }
    
    
}
