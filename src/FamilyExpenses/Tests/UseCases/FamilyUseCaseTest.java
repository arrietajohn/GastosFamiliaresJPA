package FamilyExpenses.Tests.UseCases;

import FamilyExpenses.Infrastructure.Persistences.FamilyDao;
import FamilyExpenses.Infrastructure.Persistences.UserDao;
import FamilyExpenses.Application.UseCases.Family.CreateFamilyUseCase;
import FamilyExpenses.Application.Dto.Family.CreateFamilyRequestDto;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class FamilyUseCaseTest {

    public static void createFamily_shouldSaveSuccessfully() {
        try {
            // Arrange
            var userId = "U-1";
            var name = "Villareal Family";
            var email = "farrietavillarreal@hotmail.com";
            var phoneNumber = "6784748";
            var address = "Cartagena";

            var request = new CreateFamilyRequestDto(
                    name,
                    userId,
                    address,
                    email,
                    phoneNumber
            );

            var familyDao = new FamilyDao();
            var userDao = new UserDao();
            var useCase = new CreateFamilyUseCase(familyDao, userDao);

            // Act
            var response = useCase.process(request);

            // Assert
            System.out.println("Family created, ID: " + response.getFamilyId());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
