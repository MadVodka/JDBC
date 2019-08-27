package ivan.vatlin.jdbc.services;

import ivan.vatlin.jdbc.dao.UserDao;
import ivan.vatlin.jdbc.dto.User;
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
}
