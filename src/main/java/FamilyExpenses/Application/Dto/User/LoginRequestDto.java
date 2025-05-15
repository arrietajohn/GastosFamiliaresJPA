package FamilyExpenses.Application.Dto.User;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */


public class LoginRequestDto {

    private final String userCode;
    private final String password;

    public LoginRequestDto(String userCode, String password) {
        if (userCode == null || userCode.trim().isEmpty()) {
            throw new IllegalArgumentException("ID is required.");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password is required.");
        }
        this.userCode = userCode;
        this.password = password;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getPassword() {
        return password;
    }
    
    
}
