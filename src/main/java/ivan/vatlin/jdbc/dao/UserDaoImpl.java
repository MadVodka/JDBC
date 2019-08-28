package ivan.vatlin.jdbc.dao;

import ivan.vatlin.jdbc.dto.User;
import ivan.vatlin.jdbc.dto_helpers.UserRole;
import ivan.vatlin.jdbc.mappers.UserMapper;
import ivan.vatlin.jdbc.statuses.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
        } catch (DataAccessException e) {
            return null;
        }
    }

    public List<User> getUsersByRole(UserRole userRole) {
        String sql = "select * from users where role = ?";
        return jdbcTemplate.query(sql, new UserMapper(), userRole.toString());
    }

    public long createUser(User user) {
        String sql = "insert users (userName, firstName, secondName, role) values (?, ?, ?, ?)";
        try {
            return jdbcTemplate.update(sql, user.getUserName(), user.getFirstName(), user.getSecondName(),
                    user.getUserRole().toString());
        } catch (DataAccessException e) {
            return -1;
        }
    }

    public long updateUserStatus(long id, UserStatus userStatus) {
        String sql = "update users set status = ? where id = ?";
        return jdbcTemplate.update(sql, userStatus.toString(), id);
    }

    public long deleteUser(long id) {
        String sql = "delete from users where id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
