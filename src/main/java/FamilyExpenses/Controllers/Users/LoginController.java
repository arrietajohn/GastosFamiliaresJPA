package FamilyExpenses.Controllers.Users;

import FamilyExpenses.Application.UseCases.User.LoginUseCase;
import FamilyExpenses.Application.Dto.User.LoginRequestDto;
import FamilyExpenses.Application.Dto.User.LoginResponseDto;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class LoginController {

    private final LoginUseCase loginUseCase;

    public LoginController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    public LoginResponseDto execute(LoginRequestDto request) throws Exception {
        return loginUseCase.process(request);
    }
}
