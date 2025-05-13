package FamilyExpenses.Application.Dto.User;

import FamilyExpenses.Domain.ValueObjects.UserRoleEnum;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class EditUserResponseDto {

    private final String userCode;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final UserRoleEnum role;
    private final String email;

    public EditUserResponseDto(String userCode, String password,
            String firstName, String lastName,
            UserRoleEnum role, String email) {
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
