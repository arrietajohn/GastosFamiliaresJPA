package FamilyExpenses.Domain.Entities;

import FamilyExpenses.Domain.ValueObjects.FamilyRoleEnum;
import FamilyExpenses.Domain.ValueObjects.GenderEnum;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "UserMembers")
public class UserMember implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @Column(name = "ID")
    private String id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "ID")
    private User user;

    @Column(length = 30)
    private String middleName;

    @Column(length = 50)
    private String secondLastName;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private GenderEnum gender;

    private LocalDate birthDate;

    @Column(length = 30)
    private String phoneNumber;

    @Column(length = 25)
    private String photo;

    @Column(length = 40)
    private String occupation;

    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private FamilyRoleEnum familyRole;

    @ManyToOne
    private Family family;

    @OneToMany(mappedBy = "member")
    private List<Income> incomes;

    @OneToMany(mappedBy = "member")
    private List<Expense> expenses;

    @OneToMany(mappedBy = "member")
    private List<Contribution> contributions;

    @OneToMany(mappedBy = "creator")
    private List<SavingsFund> savingsFunds;

    // Constructors
    public UserMember() {
    }

    public UserMember(User user) {
        this.user = user;
    }

    public UserMember(User user, String middleName, String secondLastName,
                  GenderEnum gender, LocalDate birthDate,
                  String occupation, Family family) {
        this.user = user;
        this.id = user.getCode(); // Can be omitted if @MapsId is used correctly
        this.middleName = middleName;
        this.secondLastName = secondLastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.occupation = occupation;
        this.family = family;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public FamilyRoleEnum getFamilyRole() {
        return familyRole;
    }

    public void setFamilyRole(FamilyRoleEnum familyRole) {
        this.familyRole = familyRole;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<Contribution> getContributions() {
        return contributions;
    }

    public void setContributions(List<Contribution> contributions) {
        this.contributions = contributions;
    }

    public List<SavingsFund> getSavingsFunds() {
        return savingsFunds;
    }

    public void setSavingsFunds(List<SavingsFund> savingsFunds) {
        this.savingsFunds = savingsFunds;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final UserMember other = (UserMember) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", user=" + user + ", middleName=" 
                + middleName + ", secondLastName=" + secondLastName + ", gender=" 
                + gender + ", birthDate=" + birthDate + ", phoneNumber=" 
                + phoneNumber + ", photo=" + photo + ", occupation=" + occupation
                + ", familyRole=" + familyRole + ", family=" + family + '}';
    }


}
