package FamilyExpenses.Application.UseCases.Family;

import FamilyExpenses.Infrastructure.Persistences.FamilyDao;
import FamilyExpenses.Infrastructure.Persistences.UserDao;
import FamilyExpenses.Application.Dto.Family.CreateFamilyRequestDto;
import FamilyExpenses.Application.Dto.Family.CreateFamilyResponseDto;
import FamilyExpenses.Domain.Entities.Family;
import FamilyExpenses.Domain.ValueObjects.UserRoleEnum;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class CreateFamilyUseCase {

    private final FamilyDao familyDao;
    private final UserDao userDao;
    // private final UserMemberDao memberDao; // Optional for future use

    public CreateFamilyUseCase(FamilyDao familyDao, UserDao userDao) {
        this.familyDao = familyDao;
        this.userDao = userDao;
    }

    public CreateFamilyResponseDto process(CreateFamilyRequestDto request) throws Exception {
        try {
            // Validate if the creator user exists
            var creatorUser = userDao.findById(request.getUserId());

            // Map request DTO to Family entity
            var newFamily = new Family(request.getName(), creatorUser);
            newFamily.setEmail(request.getEmail());
            newFamily.setPhoneNumber(request.getPhoneNumber());
            newFamily.setAddress(request.getAddress());

            // Save the Family entity
            familyDao.save(newFamily);

            // Optionally convert creator user to a UserMember
            if (creatorUser.getRole() == UserRoleEnum.USER) {
                // TODO: Convert creator user into a UserMember if not already one
            }

            // Return the new family ID
            return new CreateFamilyResponseDto(newFamily.getId());
        } catch (Exception error) {
            var message = "Failed to save new family\n" + error.getMessage();
            throw new Exception(message, error);
        }
    }
}

