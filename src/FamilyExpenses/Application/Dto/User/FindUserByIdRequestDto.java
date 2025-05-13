package FamilyExpenses.Application.Dto.User;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class FindUserByIdRequestDto {

    private final String userCode;

    public FindUserByIdRequestDto(String userCode) {
        if (userCode == null || userCode.trim().isEmpty()) {
            throw new IllegalArgumentException("ID is required.");
        }
        this.userCode = userCode;
    }

    public String userCode() {
        return userCode;
    }
    
}
