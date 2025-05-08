package GastosFamiliares.Modelo.Entidades;

import GastosFamiliares.Modelo.Enumeraciones.GeneroEnum;
import GastosFamiliares.Modelo.Enumeraciones.RolFamiliaEnum;
import GastosFamiliares.Modelo.Enumeraciones.RolUsuarioEnum;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
@Entity
public class Miembro extends Usuario implements Serializable {

    private static final long serialVersionUID = 0L;
    
    @Column(length = 30)
    private String segundoNombre;
    @Column(length = 50)
    private String segundoApellido;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private GeneroEnum genero;
    private LocalDate fechaNacimiento;
    @Column(length = 30)
    private String numeroTelefonico;
    @Column(length = 25)
    private String foto;
    @Column(length = 40)
    private String ocupacion;
//       ' Relaciones
    private RolFamiliaEnum rolFamilia;
    @ManyToOne
    private Familia familia;
    @OneToMany(mappedBy = "miembro")
    private List<Ingreso> ingresos;
    @OneToMany(mappedBy = "miembro")
    private List<Gasto> gastos;
    @OneToMany(mappedBy = "miembro")
    private List<Aporte> aportes;
    @OneToMany(mappedBy = "creador")
    private List<BolsaDeAhorro> bolsasDeAhorros;

    // Cosntructores
    public Miembro() {
    }

    public Miembro(String id, String nombre, String apellido, RolUsuarioEnum rol) {
        super(id, nombre, apellido, rol);
    }

    public Miembro(String codigo, String password, String nombre, String apellido, RolUsuarioEnum rol, String email) {
        super(codigo, password, nombre, apellido, rol, email);
    }

    public Miembro(String id, String nombre, String apellido, RolUsuarioEnum rol,
            String segundoNombre, String segundoApellido, GeneroEnum genero,
            LocalDate fechaNacimiento, String ocupacion) {
        super(id, nombre, apellido, rol);
        this.segundoNombre = segundoNombre;
        this.segundoApellido = segundoApellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.ocupacion = ocupacion;
    }

    // Set Get
    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public RolFamiliaEnum getRolFamilia() {
        return rolFamilia;
    }

    public void setRolFamilia(RolFamiliaEnum rolFamilia) {
        this.rolFamilia = rolFamilia;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public List<Ingreso> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<Ingreso> ingresos) {
        this.ingresos = ingresos;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public List<Aporte> getAportes() {
        return aportes;
    }

    public void setAportes(List<Aporte> aportes) {
        this.aportes = aportes;
    }

    public List<BolsaDeAhorro> getBolsasDeAhorros() {
        return bolsasDeAhorros;
    }

    public void setBolsasDeAhorros(List<BolsaDeAhorro> bolsasDeAhorros) {
        this.bolsasDeAhorros = bolsasDeAhorros;
    }

    @Override
    public String toString() {
        return "Miembro{" + "segundoNombre=" + segundoNombre + ", segundoApellido="
                + segundoApellido + ", genero=" + genero + ", fechaNacimiento="
                + fechaNacimiento + ", numeroTelefonico=" + numeroTelefonico
                + ", foto=" + foto + ", ocupacion=" + ocupacion + ", rolFamilia="
                + rolFamilia + ", familia=" + familia + ", ingresos=" + ingresos
                + ", gastos=" + gastos + ", aportes=" + aportes + ", bolsasDeAhorros="
                + bolsasDeAhorros + '}';
    }

}
