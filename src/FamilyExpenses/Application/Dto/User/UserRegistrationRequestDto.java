package FamilyExpenses.Application.Dto.User;

import FamilyExpenses.Domain.ValueObjects.UserRoleEnum;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class UserRegistrationRequestDto {

    private final String userCode;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final UserRoleEnum role;
    private final String email;

    public UserRegistrationRequestDto(String userCode, String password, String firstName,
            String lastName, UserRoleEnum role, String email) {

        if (userCode == null || userCode.trim().isEmpty()) {
            throw new IllegalArgumentException("ID is required.");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password is required.");
        }

        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name is required.");
        }

        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name is required.");
        }

        if (role == null) {
            throw new IllegalArgumentException("Role is required.");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email is required.");
        }

        this.userCode = userCode;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.email = email;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

}
