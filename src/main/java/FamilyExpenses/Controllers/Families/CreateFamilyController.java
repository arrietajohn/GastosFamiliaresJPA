package FamilyExpenses.Controllers.Families;

import FamilyExpenses.Application.UseCases.Family.CreateFamilyUseCase;
import FamilyExpenses.Application.Dto.Family.CreateFamilyRequestDto;
import FamilyExpenses.Application.Dto.Family.CreateFamilyResponseDto;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class CreateFamilyController {

    private final CreateFamilyUseCase useCase;

    public CreateFamilyController(CreateFamilyUseCase useCase) {
        this.useCase = useCase;
    }

    public CreateFamilyResponseDto execute(CreateFamilyRequestDto request) throws Exception {
        return useCase.process(request);
    }
}
