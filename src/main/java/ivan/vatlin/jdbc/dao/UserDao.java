package ivan.vatlin.jdbc.dao;

import ivan.vatlin.jdbc.dto.User;
import ivan.vatlin.jdbc.dto_helpers.UserRole;
import ivan.vatlin.jdbc.statuses.UserStatus;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    List<User> getOrderedUsers();

    User getUserById(long id);

    List<User> getUsersByRole(UserRole userRole);

    long createUser(User user);

    long updateUserStatus(long id, UserStatus userStatus);

    long deleteUser(long id);
}
