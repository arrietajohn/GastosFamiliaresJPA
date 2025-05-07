package GastosFamiliares.Modelo.Entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class Aporte implements Serializable{

    private int id; //' Autoincremental
    private LocalDateTime fechaRegistro;
    private float valor;
    //       ' Realaciones
    private BolsaDeAhorro bolsaDeAhoro;
    private Miembro miembre;
    private Ingreso ingreso;
    private Gasto gasto;
    
    // Constructores

    public Aporte() {
    }

    public Aporte(float valor, BolsaDeAhorro bolsaDeAhoro, Miembro miembre, Ingreso ingreso) {
        this.valor = valor;
        this.bolsaDeAhoro = bolsaDeAhoro;
        this.miembre = miembre;
        this.ingreso = ingreso;
    }

    
    public Aporte(int id, LocalDateTime fechaRegistro, float valor, BolsaDeAhorro bolsaDeAhoro, Miembro miembre, Ingreso ingreso, Gasto gasto) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
        this.valor = valor;
        this.bolsaDeAhoro = bolsaDeAhoro;
        this.miembre = miembre;
        this.ingreso = ingreso;
        this.gasto = gasto;
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

    public BolsaDeAhorro getBolsaDeAhoro() {
        return bolsaDeAhoro;
    }

    public void setBolsaDeAhoro(BolsaDeAhorro bolsaDeAhoro) {
        this.bolsaDeAhoro = bolsaDeAhoro;
    }

    public Miembro getMiembre() {
        return miembre;
    }

    public void setMiembre(Miembro miembre) {
        this.miembre = miembre;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }

    public Gasto getGasto() {
        return gasto;
    }

    public void setGasto(Gasto gasto) {
        this.gasto = gasto;
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
                + ", valor=" + valor + ", bolsaDeAhoro=" + bolsaDeAhoro 
                + ", miembre=" + miembre + ", ingreso=" + ingreso 
                + ", gasto=" + gasto + '}';
    }
    
    
    

}
