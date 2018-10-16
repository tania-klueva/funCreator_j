package ua.com.funCreator.services.userService;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.com.funCreator.dto.UserDTO;
import ua.com.funCreator.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    ua.com.funCreator.models.User save(UserDTO userDTO) throws UserServiceImpl.EmailExistsException;
    User deleteById(long id);
    User update(UserDTO userDTO, User user);
    List<User> findAll();
    User findById(long id);
}
