package FamilyExpenses.Domain.Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Families")
public class Family implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 150, nullable = false)
    private String name;

    private String address;

    @Column(length = 30)
    private String phoneNumber;

    @Column(length = 70, unique = true)
    private String email;

    // Relationships
    @ManyToOne(optional = true)
    @JoinColumn(name = "CREATOR_USER_ID")
    private User creator;

    @OneToMany(mappedBy = "family")
    private List<UserMember> members;

    @OneToMany(mappedBy = "family")
    private List<SavingsFund> savingsFunds;

    // Constructors
    public Family() {
    }

    public Family(String name, User creator) {
        this.name = name;
        this.creator = creator;
    }

    public Family(int id, String name, User creator, String address,
                  String phoneNumber, String email,
                  List<UserMember> members, List<SavingsFund> savingsFunds) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.members = members;
        this.savingsFunds = savingsFunds;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<UserMember> getMembers() {
        return members;
    }

    public void setMembers(List<UserMember> members) {
        this.members = members;
    }

    public List<SavingsFund> getSavingsFunds() {
        return savingsFunds;
    }

    public void setSavingsFunds(List<SavingsFund> savingsFunds) {
        this.savingsFunds = savingsFunds;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
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
        final Family other = (Family) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Family{" + "id=" + id + ", name=" + name + ", address=" + address
                + ", phoneNumber=" + phoneNumber + ", email=" + email 
                + ", creator=" + creator + '}';
    }


}
