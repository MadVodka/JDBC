package ivan.vatlin.jdbc.dao;

import ivan.vatlin.jdbc.dto.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    List<User> getAdmins();

    long addUser(User user);
}
