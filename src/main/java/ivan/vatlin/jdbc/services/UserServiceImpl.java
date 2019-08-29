package ivan.vatlin.jdbc.services;

import ivan.vatlin.jdbc.dao.UserDao;
import ivan.vatlin.jdbc.dto.User;
import ivan.vatlin.jdbc.dto_helpers.UserRole;
import ivan.vatlin.jdbc.statuses.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public List<User> getOrderedUsers() {
        return userDao.getOrderedUsers();
    }

    public User getUserById(long id) {
        try {
            return userDao.getUserById(id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<User> getClients() {
        return userDao.getUsersByRole(UserRole.CLIENT);
    }

    public List<User> getAdmins() {
        return userDao.getUsersByRole(UserRole.ADMIN);
    }

    public long createUser(User user) {
        return userDao.createUser(user);
    }

    public long activateUser(long id) {
        return userDao.updateUserStatus(id, UserStatus.ACTIVE);
    }

    public long blockUser(long id) {
        return userDao.updateUserStatus(id, UserStatus.BLOCKED);
    }

    public long deleteUser(long id) {
        return userDao.deleteUser(id);
    }
}
