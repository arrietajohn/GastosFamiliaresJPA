package FamilyExpenses.Tests.Persistences;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */


import FamilyExpenses.Domain.Entities.Family;
import FamilyExpenses.Domain.Entities.User;
import FamilyExpenses.Domain.Entities.UserMember;
import FamilyExpenses.Domain.ValueObjects.FamilyRoleEnum;
import FamilyExpenses.Domain.ValueObjects.GenderEnum;
import FamilyExpenses.Domain.ValueObjects.UserRoleEnum;
import FamilyExpenses.Infrastructure.Persistences.UserMemberDao;
import java.time.LocalDate;

public class UserMemberDaoTest {

    public static void saveUserMember_shouldSaveWithoutErrors() {
        try {
            var user = new User("U-1", "Abc**", "Fulanito1", "De Tal", UserRoleEnum.USER, "fulanito1@gmail.com");

            var family = new Family(
                1,
                "Arrieta Villarreal",
                user,
                "Cartagena",
                "12334",
                "farrietavillareal@gmail.com",
                null,
                null
            );

            var member = new UserMember(
                user,
                "First",
                "Pascual",
                GenderEnum.MALE,
                LocalDate.now().minusYears(47),
                "Developer",
                family
            );

            member.setFamilyRole(FamilyRoleEnum.FATHER);
            member.setPhoneNumber("234234");

            var userMemberDao = new UserMemberDao();

            // Act
            userMemberDao.save(member);

            // Assert
            System.out.println("UserMember saved successfully");

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
