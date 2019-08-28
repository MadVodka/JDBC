package ivan.vatlin.jdbc.services;

import ivan.vatlin.jdbc.dto.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(long id);

    List<User> getClients();

    List<User> getAdmins();

    long createUser(User user);

    long activateUser(long id);

    long blockUser(long id);

    long deleteUser(long id);
}
