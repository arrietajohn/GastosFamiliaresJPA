package FamilyExpenses.Application.UseCases.User;

import FamilyExpenses.Infrastructure.Persistences.UserDao;
import FamilyExpenses.Application.Dto.User.LoginRequestDto;
import FamilyExpenses.Application.Dto.User.LoginResponseDto;
import FamilyExpenses.Domain.Entities.User;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class LoginUseCase {

    private final UserDao userDao;

    public LoginUseCase(UserDao userDao) {
        this.userDao = userDao;
    }

    public LoginResponseDto process(LoginRequestDto request) throws Exception {
        try {
            User user = userDao.findById(request.getUserCode());
            if (!user.getPassword().equals(request.getPassword())) {
                throw new Exception("Unauthorized");
            }

            return new LoginResponseDto(
                    user.getCode(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getRole(),
                    user.getEmail()
            );
        } catch (Exception e) {
            throw e;
        }
    }
}
