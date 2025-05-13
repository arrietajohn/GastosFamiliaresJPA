package FamilyExpenses.Application.UseCases.User;

import FamilyExpenses.Infrastructure.Persistences.UserDao;
import FamilyExpenses.Application.Dto.User.EditUserRequestDto;
import FamilyExpenses.Application.Dto.User.EditUserResponseDto;
import FamilyExpenses.Domain.Entities.User;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class EditUserUseCase {

    private final UserDao userDao;

    public EditUserUseCase(UserDao userDao) {
        this.userDao = userDao;
    }

    public EditUserResponseDto process(EditUserRequestDto request) throws Exception {
        try {
            var user = new User(
                    request.getUserCode(),
                    request.getPassword(),
                    request.getFirstName(),
                    request.getLastName(),
                    request.getRole(),
                    request.getEmail()
            );

            userDao.update(user);

            return new EditUserResponseDto(
                    user.getCode(),
                    user.getPassword(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getRole(),
                    user.getEmail()
            );
        } catch (Exception error) {
            var message = "Unable to update the user\n" + error.getMessage();
            throw new Exception(message, error);
        }
    }
}
