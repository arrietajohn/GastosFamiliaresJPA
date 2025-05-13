package FamilyExpenses.Domain.Entities;

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
@Table(name = "Contributions")
public class Contribution implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime recordDate;

    @Column(nullable = false)
    private float amount;

    // Relationships
    @ManyToOne(optional = false)
    private SavingsFund savingsFund;

    @ManyToOne(optional = false)
    private UserMember member;

    @ManyToOne(optional = false)
    private Income income;

    // Constructors
    public Contribution() {
    }

    public Contribution(float amount, SavingsFund savingsFund, UserMember member, Income income) {
        this.amount = amount;
        this.savingsFund = savingsFund;
        this.member = member;
        this.income = income;
    }

    public Contribution(int id, LocalDateTime recordDate, float amount,
                        SavingsFund savingsFund, UserMember member, Income income) {
        this.id = id;
        this.recordDate = recordDate;
        this.amount = amount;
        this.savingsFund = savingsFund;
        this.member = member;
        this.income = income;
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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public SavingsFund getSavingsFund() {
        return savingsFund;
    }

    public void setSavingsFund(SavingsFund savingsFund) {
        this.savingsFund = savingsFund;
    }

    public UserMember getMember() {
        return member;
    }

    public void setMember(UserMember member) {
        this.member = member;
    }

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Contribution other = (Contribution) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Contribution{" + "id=" + id + ", recordDate=" 
                + recordDate + ", amount=" + amount + ", savingsFund=" 
                + savingsFund + ", member=" + member + ", income=" + income + '}';
    }


}
