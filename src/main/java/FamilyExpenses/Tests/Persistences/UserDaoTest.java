package FamilyExpenses.Tests.Persistences;

import FamilyExpenses.Infrastructure.Persistences.UserDao;
import FamilyExpenses.Domain.Entities.User;
import FamilyExpenses.Domain.ValueObjects.UserRoleEnum;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public class UserDaoTest {

    // Arrange-Act-Assert
    public static void createNewUser_shouldSaveWithoutError() {
        // Arrange
        var user = new User(
                "U-1",
                "!23Abc$$",
                "Fulanito1",
                "De Tal",
                UserRoleEnum.USER,
                "fulanito1@gmail.com");

        try {
            var userDao = new UserDao();
            // Act
            userDao.save(user);
            // Assert
            System.out.println("User saved successfully. ID: " + user.getCode());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void findUserById_shouldDisplayUserDetails() {
        // Arrange
        var id = "U-1";
        try {
            var userDao = new UserDao();
            // Act
            var user = userDao.findById(id);
            // Assert
            System.out.println(user);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void listAllUsers_shouldPrintEachUser() {
        // Arrange
        var userDao = new UserDao();
        // Act
        var users = userDao.findAll();
        // Assert
        for (var user : users) {
            System.out.println("--------------");
            System.out.println(user);
        }
        if (users.isEmpty()) {
            System.out.println("No users found in the system.");
        }
    }

    public static void updateUser_shouldUpdateWithoutError() {
        // Arrange
        var user = new User(
                "U-7",
                "XXYYZZ...",
                "FulanitoXyz",
                "De Tal",
                UserRoleEnum.USER,
                "fulanitoxyz@gmail.com");
        var userDao = new UserDao();

        try {
            // Act
            userDao.update(user);
            // Assert
            System.out.println("User updated successfully.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void deleteUserById_shouldDeleteWithoutError() {
        // Arrange
        var id = "U-1";
        var userDao = new UserDao();
        try {
            // Act
            userDao.deleteById(id);
            // Assert
            System.out.println("User deleted successfully.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

