package FamilyExpenses.Domain.Entities;


import FamilyExpenses.Domain.ValueObjects.UserRoleEnum;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
@Entity
@Table(name = "Users")
public class User implements Serializable {

    private static final long serialVersionUID = 0L;
    @Id
    @Column(name = "ID", length = 20)
    protected String code;
    @Column(length = 30, nullable = false)
    protected String password;
    @Column(length = 40, nullable = false)
    protected String firstName;
    @Column(length = 50, nullable = false)
    protected String lastName;
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    protected UserRoleEnum role;
    @Column(length = 70, nullable = false, unique = true)
    protected String email;

    // Default constructor, using JPA
    public User() {

    }

    // Constructor with parameters

    public User(String code, String password, String name, String lastName, UserRoleEnum role, String email) {
        this.code = code;
        this.password = password;
        this.firstName = name;
        this.lastName = lastName;
        this.role = role;
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

  
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.code);
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
        final User other = (User) obj;
        return Objects.equals(this.code, other.code);
    }

    @Override
    public String toString() {
        return "User{" + "code=" + code + ", password=" + password + 
                ", name=" + firstName + ", lastName=" + lastName + ", role=" + role 
                + ", email=" + email + '}';
    }
    
    
  
}
