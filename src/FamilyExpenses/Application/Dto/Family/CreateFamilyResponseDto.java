package FamilyExpenses.Application.Dto.Family;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class CreateFamilyResponseDto {

    private final int familyId;

    public CreateFamilyResponseDto(int familyId) {
        this.familyId = familyId;
    }

    public int getFamilyId() {
        return familyId;
    }
}

