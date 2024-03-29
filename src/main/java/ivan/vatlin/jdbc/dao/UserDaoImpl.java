package ivan.vatlin.jdbc.dao;

import ivan.vatlin.jdbc.dto.User;
import ivan.vatlin.jdbc.dto_helpers.UserRole;
import ivan.vatlin.jdbc.mappers.UserMapper;
import ivan.vatlin.jdbc.statuses.UserStatus;
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

    public List<User> getOrderedUsers() {
        String sql = "select * from users order by second_name, first_name";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    public User getUserById(long id) {
        String sql = "select * from users where id = ?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    public User getUserByUserName(String userName) {
        String sql = "select * from users where user_name = ?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), userName);
    }

    public List<User> getUsersByRole(UserRole userRole) {
        String sql = "select * from users where role = ?";
        return jdbcTemplate.query(sql, new UserMapper(), userRole.toString());
    }

    public int createUser(User user) {
        String sql = "insert users (user_name, first_name, second_name, role) values (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getUserName(), user.getFirstName(), user.getSecondName(),
                user.getUserRole().toString());
    }

    public int updateUserStatus(long id, UserStatus userStatus) {
        String sql = "update users set status = ? where id = ?";
        return jdbcTemplate.update(sql, userStatus.toString(), id);
    }

    public int deleteUser(long id) {
        String sql = "delete from users where id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
