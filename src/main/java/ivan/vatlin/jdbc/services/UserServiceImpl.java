package ivan.vatlin.jdbc.services;

import ivan.vatlin.jdbc.dao.UserDao;
import ivan.vatlin.jdbc.dto.User;
import ivan.vatlin.jdbc.dto_helpers.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    public List<User> getClients() {
        return userDao.getUsersByRole(UserRole.CLIENT);
    }

    public List<User> getAdmins() {
        return userDao.getUsersByRole(UserRole.ADMIN);
    }

    public long blockUser(long id) {
        return 0;
    }

    public long createUser(User user) {
        return 0;
    }
}
