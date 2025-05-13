package FamilyExpenses.Controllers.Users;

import FamilyExpenses.Application.UseCases.User.FindUserByIdUseCase;
import FamilyExpenses.Application.Dto.User.FindUserByIdRequestDto;
import FamilyExpenses.Application.Dto.User.FindUserByIdResponseDto;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */


public class FindUserByIdController {

    private final FindUserByIdUseCase useCase;

    public FindUserByIdController(FindUserByIdUseCase useCase) {
        this.useCase = useCase;
    }

    public FindUserByIdResponseDto execute(FindUserByIdRequestDto request) throws Exception {
        return useCase.process(request);
    }
}
