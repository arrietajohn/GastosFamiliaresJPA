package FamilyExpenses.Application.Dto.Family;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class CreateFamilyRequestDto {

    private final String name;
    private final String userId;
    private final String address;
    private final String email;
    private final String phoneNumber;

    public CreateFamilyRequestDto(String name, String userId, String address, String email, String phoneNumber) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Family name is required.");
        }
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("Creator user ID is required.");
        }
        this.name = name;
        this.userId = userId;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

