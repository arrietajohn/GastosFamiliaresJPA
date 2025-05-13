package FamilyExpenses.Controllers.Users;

import FamilyExpenses.Application.UseCases.User.EditUserUseCase;
import FamilyExpenses.Application.Dto.User.EditUserRequestDto;
import FamilyExpenses.Application.Dto.User.EditUserResponseDto;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class EditUserController {

    private final EditUserUseCase useCase;

    public EditUserController(EditUserUseCase useCase) {
        this.useCase = useCase;
    }

    public EditUserResponseDto execute(EditUserRequestDto request) throws Exception {
        return useCase.process(request);
    }
}
