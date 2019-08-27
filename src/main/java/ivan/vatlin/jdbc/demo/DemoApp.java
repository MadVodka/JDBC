package ivan.vatlin.jdbc.demo;

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
    }
}
