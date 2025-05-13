package FamilyExpenses.Tests.Persistences;

import FamilyExpenses.Infrastructure.Persistences.FamilyDao;
import FamilyExpenses.Domain.Entities.Family;
import FamilyExpenses.Domain.Entities.User;
import FamilyExpenses.Domain.ValueObjects.UserRoleEnum;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class FamilyDaoTest {

    public static void saveFamily_shouldSaveFamilyWithoutError() {
        // Arrange
        var user = new User(
                "77788899",
                "Abc**",
                "John",
                "Arrieta",
                UserRoleEnum.USER,
                ""
        );

        var family = new Family("Arrieta Arrieta", user);
        family.setAddress("Cartagena");
        family.setEmail("farrietaarrieta@gmail.com");
        family.setPhoneNumber("301774455678");

        var familyDao = new FamilyDao();

        try {
            // Act
            familyDao.save(family);
            System.out.println("Family created, ID: " + family.getId());
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }

        // Assert (Manual or future validation goes here)
    }
}

