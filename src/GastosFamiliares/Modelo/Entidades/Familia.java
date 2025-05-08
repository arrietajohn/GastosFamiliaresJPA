package GastosFamiliares.Modelo.Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
@Entity
@Table(name = "Familias")
public class Familia implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 150, nullable = false)
    private String nombre;
    private String direccion;
    @Column(length = 30)
    private String numeroDeTelefono;
    @Column(length = 70, unique = true)
    private String email;
//    ' Relaciones
    @ManyToOne(optional = true)
    @JoinColumn(name = "USUARIO_CREADOR_ID")
    private Usuario creador;
    @OneToMany(mappedBy = "familia")
    private List<Miembro> miembros;
    @OneToMany(mappedBy = "familia")
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
