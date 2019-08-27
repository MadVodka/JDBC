package ivan.vatlin.jdbc.services;

import ivan.vatlin.jdbc.dto.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
}
