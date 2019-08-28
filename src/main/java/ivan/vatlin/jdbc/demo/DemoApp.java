package ivan.vatlin.jdbc.demo;

import ivan.vatlin.jdbc.dto.User;
import ivan.vatlin.jdbc.dto_helpers.UserRole;
import ivan.vatlin.jdbc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoApp {
    @Autowired
    private UserService userService;

    public void run() {
        actionsOnUsers();
    }

    private void actionsOnUsers() {
        System.out.println("------ All users ------");
        System.out.println(userService.getAllUsers());

        System.out.println("------ Some user by id ------");
        System.out.println(userService.getUserById(10));

        System.out.println("------ Users with admin role ------");
        System.out.println(userService.getAdmins());

        System.out.println("------ Create a new user as client ------");
        User user = new User();
        user.setUserName("igorIgor")
                .setFirstName("Игорь")
                .setSecondName("Великий")
                .setUserRole(UserRole.CLIENT);
        System.out.println(user);
        System.out.println(userService.createUser(user));

        System.out.println("------ Block a user ------");
        System.out.println(userService.blockUser(16) > 0 ? "User has been blocked" : "Can't block the user");

        System.out.println("------ Activate a user ------");
        System.out.println(userService.activateUser(16) > 0 ? "User has been activated" : "Can't activate the user");

    }
}
