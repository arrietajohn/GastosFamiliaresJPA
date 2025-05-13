package FamilyExpenses.Domain.Entities;

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
@Table(name = "Sources")
public class Source implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    private String description;

    @Column(length = 20)
    private String icon;

    // Relationships
    @OneToMany(mappedBy = "source")
    private List<Income> incomes;

    // Constructors
    public Source() {
    }

    public Source(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Source(int id, String name, String description, String icon, List<Income> incomes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.incomes = incomes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.name);
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
        final Source other = (Source) obj;
        return Objects.equals(this.name, other.name);
    }

  

    @Override
    public String toString() {
        return "Source{" + "id=" + id + ", name=" + name + ", description=" 
                + description + ", icon=" + icon + '}';
    }

   

}
