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

    public User getUserByUserName(String userName) {
        try {
            return userDao.getUserByUserName(userName);
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

    public int createUser(User user) {
        if (getUserByUserName(user.getUserName()) == null) {
            return userDao.createUser(user);
        } else {
            return -1;
        }
    }

    public int activateUser(long id) {
        return userDao.updateUserStatus(id, UserStatus.ACTIVE);
    }

    public int blockUser(long id) {
        return userDao.updateUserStatus(id, UserStatus.BLOCKED);
    }

    public int deleteUser(long id) {
        return userDao.deleteUser(id);
    }
}
