package GastosFamiliares.Modelo.Entidades;

import GastosFamiliares.Modelo.Enumeraciones.EstadoBolsaAhorroEnum;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "Bolsas_de_ahorros")
public class BolsaDeAhorro implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime fechaRegistro;
    @Column(nullable = false)
    private LocalDate fechaIncia;
    private LocalDate fechaFin;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false)
    private float montoIdeal;
    private String proposito;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private EstadoBolsaAhorroEnum estado;
    //      ' Realaciones
    @ManyToOne
    private Familia familia;
    @ManyToOne
    @JoinColumn(name = "USUARIO_CREADOR_ID")
    private Miembro creador;
    @OneToMany(mappedBy = "bolsaDeAhorro")
    private List<Aporte> aportes;

    // Constructores
    public BolsaDeAhorro() {
    }

    public BolsaDeAhorro(LocalDate fechaIncia, LocalDate fechaFin, String nombre, float montoIdeal, String proposito, Familia familia, Miembro creador) {
        this.fechaIncia = fechaIncia;
        this.fechaFin = fechaFin;
        this.nombre = nombre;
        this.montoIdeal = montoIdeal;
        this.proposito = proposito;
        this.familia = familia;
        this.creador = creador;
    }

    public BolsaDeAhorro(int id, LocalDateTime fechaRegistro, LocalDate fechaIncia,
            LocalDate fechaFin, String nombre, float montoIdeal, String proposito,
            EstadoBolsaAhorroEnum estado, Familia familia, Miembro creador,
            List<Aporte> aportes) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
        this.fechaIncia = fechaIncia;
        this.fechaFin = fechaFin;
        this.nombre = nombre;
        this.montoIdeal = montoIdeal;
        this.proposito = proposito;
        this.estado = estado;
        this.familia = familia;
        this.creador = creador;
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

    public LocalDate getFechaIncia() {
        return fechaIncia;
    }

    public void setFechaIncia(LocalDate fechaIncia) {
        this.fechaIncia = fechaIncia;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getMontoIdeal() {
        return montoIdeal;
    }

    public void setMontoIdeal(float montoIdeal) {
        this.montoIdeal = montoIdeal;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public EstadoBolsaAhorroEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoBolsaAhorroEnum estado) {
        this.estado = estado;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public Miembro getCreador() {
        return creador;
    }

    public void setCreador(Miembro creador) {
        this.creador = creador;
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
        final BolsaDeAhorro other = (BolsaDeAhorro) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "BolsaDeAhorro{" + "id=" + id + ", fechaRegistro=" + fechaRegistro
                + ", fechaIncia=" + fechaIncia + ", fechaFin=" + fechaFin
                + ", nombre=" + nombre + ", montoIdeal=" + montoIdeal
                + ", proposito=" + proposito + ", estado=" + estado + ", familia="
                + familia + ", creador=" + creador
                + ", aportes=" + (aportes != null ? aportes.size() : 0) + '}';
    }

}
