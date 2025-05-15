package FamilyExpenses.Application.UseCases.User;

import FamilyExpenses.Infrastructure.Persistences.UserDao;
import FamilyExpenses.Application.Dto.User.FindUserByIdRequestDto;
import FamilyExpenses.Application.Dto.User.FindUserByIdResponseDto;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */


public class FindUserByIdUseCase {

    private final UserDao userDao;

    public FindUserByIdUseCase(UserDao userDao) {
        this.userDao = userDao;
    }

    public FindUserByIdResponseDto process(FindUserByIdRequestDto request) throws Exception {
        try {
            var user = userDao.findById(request.userCode());

            return new FindUserByIdResponseDto(
                    user.getCode(),
                    user.getPassword(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getRole(),
                    user.getEmail()
            );
        } catch (Exception error) {
            var message = "Unable to retrieve user\n" + error.getMessage();
            throw new Exception(message, error);
        }
    }
}

