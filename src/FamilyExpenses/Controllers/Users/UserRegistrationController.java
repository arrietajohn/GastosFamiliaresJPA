package FamilyExpenses.Controllers.Users;

import FamilyExpenses.Application.UseCases.User.UserRegistrationUserCase;
import FamilyExpenses.Application.Dto.User.UserRegistrationRequestDto;
import FamilyExpenses.Application.Dto.User.UserRegistrationResponseDto;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class UserRegistrationController {

    private final UserRegistrationUserCase useCase;

    public UserRegistrationController(UserRegistrationUserCase useCase) {
        this.useCase = useCase;
    }

    public UserRegistrationResponseDto execute(UserRegistrationRequestDto request) throws Exception {
        return useCase.process(request);
    }
}

