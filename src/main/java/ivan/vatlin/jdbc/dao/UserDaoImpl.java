package ivan.vatlin.jdbc.dao;

import ivan.vatlin.jdbc.dto.User;
import ivan.vatlin.jdbc.dto_helpers.UserRole;
import ivan.vatlin.jdbc.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers() {
        String sql = "select * from users";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    public User getUserById(long id) {
        String sql = "select * from users where id = ?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    public List<User> getUsersByRole(UserRole userRole) {
        String sql = "select * from users where role = ?";
        return jdbcTemplate.query(sql, new UserMapper(), userRole.toString());
    }

    public long createUser(User user) {
        return 0;
    }

    public long blockUser(long id) {
        return 0;
    }
}
