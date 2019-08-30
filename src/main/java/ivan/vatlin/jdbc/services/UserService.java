package ivan.vatlin.jdbc.services;

import ivan.vatlin.jdbc.dto.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    List<User> getOrderedUsers();

    User getUserById(long id);

    User getUserByUserName(String userName);

    List<User> getClients();

    List<User> getAdmins();

    int createUser(User user);

    int activateUser(long id);

    int blockUser(long id);

    int deleteUser(long id);
}
