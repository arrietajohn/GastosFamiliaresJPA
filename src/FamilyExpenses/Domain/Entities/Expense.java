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
@Table(name = "Expenses")
public class Expense implements Serializable {

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
    private UserMember member;

    @ManyToOne(optional = true)
    @JoinColumn(nullable = true)
    private Contribution contribution;

    @ManyToMany
    @JoinTable(
        name = "Expense_Categories",
        joinColumns = @JoinColumn(name = "EXPENSE_ID"),
        inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID")
    )
    private List<Category> categories;

    // Constructors
    public Expense() {
    }

    public Expense(LocalDate date, String name, float amount, UserMember member) {
        this.date = date;
        this.name = name;
        this.amount = amount;
        this.member = member;
    }

    public Expense(int id,
                   LocalDateTime recordDate,
                   LocalDate date,
                   String name,
                   float amount,
                   String description,
                   UserMember member,
                   List<Category> categories,
                   Contribution contribution) {
        this.id = id;
        this.recordDate = recordDate;
        this.date = date;
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.member = member;
        this.categories = categories;
        this.contribution = contribution;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public UserMember getMember() {
        return member;
    }

    public void setMember(UserMember member) {
        this.member = member;
    }

    public Contribution getContribution() {
        return contribution;
    }

    public void setContribution(Contribution contribution) {
        this.contribution = contribution;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
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
        final Expense other = (Expense) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Expense{" + "id=" + id + ", recordDate=" + recordDate + 
                ", date=" + date + ", name=" + name + ", amount=" + amount 
                + ", description=" + description + ", member=" + member 
                + ", contribution=" + contribution + ", categories=" + categories + '}';
    }

 
 
}


