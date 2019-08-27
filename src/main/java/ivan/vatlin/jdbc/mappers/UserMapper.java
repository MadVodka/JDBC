package ivan.vatlin.jdbc.mappers;

import ivan.vatlin.jdbc.dto.User;
import ivan.vatlin.jdbc.dto_helpers.UserRole;
import ivan.vatlin.jdbc.statuses.UserStatus;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setId(resultSet.getLong("id"))
                .setUserName(resultSet.getString("userName"))
                .setFirstName(resultSet.getString("firstName"))
                .setSecondName(resultSet.getString("secondName"))
                .setUserRole(UserRole.valueOf(resultSet.getString("role")))
                .setUserStatus(UserStatus.valueOf(resultSet.getString("status")));

        return user;
    }
}
