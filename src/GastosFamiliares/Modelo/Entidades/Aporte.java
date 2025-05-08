package GastosFamiliares.Modelo.Entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
@Entity
@Table(name = "Aportes")
public class Aporte implements Serializable{

    private static final long serialVersionUID = 0L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    private LocalDateTime fechaRegistro;
    @Column(nullable = false)
    private float valor;
    //       ' Realaciones
    @ManyToOne(optional = false)
    private BolsaDeAhorro bolsaDeAhorro;
    @ManyToOne(optional = false)
    private Miembro miembro;
    @ManyToOne(optional = false)
    private Ingreso ingreso;
    
    // Constructores

    public Aporte() {
    }

    public Aporte(float valor, BolsaDeAhorro bolsaDeAhoro, Miembro miembre, Ingreso ingreso) {
        this.valor = valor;
        this.bolsaDeAhorro = bolsaDeAhoro;
        this.miembro = miembre;
        this.ingreso = ingreso;
    }

    
    public Aporte(int id, LocalDateTime fechaRegistro, float valor, BolsaDeAhorro bolsaDeAhoro, Miembro miembre, Ingreso ingreso) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
        this.valor = valor;
        this.bolsaDeAhorro = bolsaDeAhoro;
        this.miembro = miembre;
        this.ingreso = ingreso;

    }
    
    // Get y Set

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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public BolsaDeAhorro getBolsaDeAhorro() {
        return bolsaDeAhorro;
    }

    public void setBolsaDeAhorro(BolsaDeAhorro bolsaDeAhorro) {
        this.bolsaDeAhorro = bolsaDeAhorro;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }
    
    public Ingreso getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
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
        final Aporte other = (Aporte) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Aporte{" + "id=" + id + ", fechaRegistro=" + fechaRegistro 
                + ", valor=" + valor + ", bolsaDeAhoro=" + bolsaDeAhorro 
                + ", miembre=" + miembro + ", ingreso=" + ingreso + " \"}";
    }
    
    
    

}
