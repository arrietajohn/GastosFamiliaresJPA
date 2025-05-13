package FamilyExpenses.Application.UseCases.User;

import FamilyExpenses.Infrastructure.Persistences.UserDao;
import FamilyExpenses.Application.Dto.User.UserRegistrationRequestDto;
import FamilyExpenses.Application.Dto.User.UserRegistrationResponseDto;
import FamilyExpenses.Domain.Entities.User;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class UserRegistrationUserCase {

    private final UserDao userDao;
    // private final EmailService emailService;

    public UserRegistrationUserCase(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserRegistrationResponseDto process(UserRegistrationRequestDto request) throws Exception {
        try {
            var user = new User(
                    request.getUserCode(),
                    request.getPassword(),
                    request.getFirstName(),
                    request.getLastName(),
                    request.getRole(),
                    request.getEmail()
            );

            userDao.save(user);
            // emailService.send(request);

            return new UserRegistrationResponseDto(
                    user.getCode(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getRole(),
                    user.getEmail()
            );
        } catch (Exception error) {
            var message = "Unable to register user\n" + error.getMessage();
            throw new Exception(message, error);
        }
    }
}
