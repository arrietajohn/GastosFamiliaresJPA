package FamilyExpenses.Domain.Entities;

import FamilyExpenses.Domain.ValueObjects.SavingsFundStatusEnum;
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
@Table(name = "Savings_Funds")
public class SavingsFund implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime recordDate;

    @Column(nullable = false)
    private LocalDate startDate;

    private LocalDate endDate;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private float targetAmount;

    private String purpose;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private SavingsFundStatusEnum status;

    // Relationships
    @ManyToOne
    private Family family;

    @ManyToOne
    @JoinColumn(name = "CREATOR_USER_ID")
    private UserMember creator;

    @OneToMany(mappedBy = "savingsFund")
    private List<Contribution> contributions;

    // Constructors
    public SavingsFund() {
    }

    public SavingsFund(LocalDate startDate, LocalDate endDate, String name,
            float targetAmount, String purpose,
            Family family, UserMember creator) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.targetAmount = targetAmount;
        this.purpose = purpose;
        this.family = family;
        this.creator = creator;
    }

    public SavingsFund(int id, LocalDateTime recordDate, LocalDate startDate,
            LocalDate endDate, String name, float targetAmount,
            String purpose, SavingsFundStatusEnum status,
            Family family, UserMember creator, List<Contribution> contributions) {
        this.id = id;
        this.recordDate = recordDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.targetAmount = targetAmount;
        this.purpose = purpose;
        this.status = status;
        this.family = family;
        this.creator = creator;
        this.contributions = contributions;
    }

    // Getters, setters, and toString() can be added as needed
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(float targetAmount) {
        this.targetAmount = targetAmount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public SavingsFundStatusEnum getStatus() {
        return status;
    }

    public void setStatus(SavingsFundStatusEnum status) {
        this.status = status;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public UserMember getCreator() {
        return creator;
    }

    public void setCreator(UserMember creator) {
        this.creator = creator;
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
        hash = 67 * hash + this.id;
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
        final SavingsFund other = (SavingsFund) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "SavingsFund{" + "id=" + id + ", recordDate=" + recordDate 
                + ", startDate=" + startDate + ", endDate=" + endDate 
                + ", name=" + name + ", targetAmount=" + targetAmount 
                + ", purpose=" + purpose + ", status=" + status 
                + ", family=" + family + ", creator=" + creator + '}';
    }

}
