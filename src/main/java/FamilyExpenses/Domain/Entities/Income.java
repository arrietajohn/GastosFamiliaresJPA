package FamilyExpenses.Domain.Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

@Entity
@Table(name = "Incomes")
public class Income implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime recordDate;

    private LocalDate date;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private float amount;

    private String description;

    // Relationships
    @ManyToOne
    private Source source;

    @ManyToOne
    private UserMember member;

    @OneToMany(mappedBy = "income")
    private List<Contribution> contributions;

    // Constructors
    public Income() {
    }

    public Income(LocalDate date, String name, float amount, Source source, UserMember member) {
        this.date = date;
        this.name = name;
        this.amount = amount;
        this.source = source;
        this.member = member;
    }

    public Income(int id,
            LocalDateTime recordDate,
            LocalDate date,
            String name,
            float amount,
            String description,
            Source source,
            UserMember member,
            List<Contribution> contributions) {
        this.id = id;
        this.recordDate = recordDate;
        this.date = date;
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.source = source;
        this.member = member;
        this.contributions = contributions;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public LocalDateTime getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDateTime recordDate) {
        this.recordDate = recordDate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public UserMember getMember() {
        return member;
    }

    public void setMember(UserMember member) {
        this.member = member;
    }

    public List<Contribution> getContributions() {
        return contributions;
    }

    public void setContributions(List<Contribution> contributions) {
        this.contributions = contributions;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
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
        final Income other = (Income) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Income{"
                + "id=" + id
                + ", recordDate=" + recordDate
                + ", date=" + date
                + ", name='" + name + '\''
                + ", amount=" + amount
                + ", description='" + description + '\''
                + ", source=" + source
                + ", member=" + member
                + ", contributions=" + contributions
                + '}';
    }
}
