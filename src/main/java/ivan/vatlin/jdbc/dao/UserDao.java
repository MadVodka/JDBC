package ivan.vatlin.jdbc.dao;

import ivan.vatlin.jdbc.dto.User;
import ivan.vatlin.jdbc.dto_helpers.UserRole;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUserById(long id);

    List<User> getUsersByRole(UserRole userRole);

    long createUser(User user);

    long blockUser(long id);
}
