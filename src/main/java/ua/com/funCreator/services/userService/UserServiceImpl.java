package ua.com.funCreator.services.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.funCreator.dao.UserDAO;
import ua.com.funCreator.dto.UserDTO;
import ua.com.funCreator.models.User;
import ua.com.funCreator.utils.UserEditor;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    private final
    UserDAO userDAO;

    private final UserEditor editor;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, UserEditor editor) {
        this.userDAO = userDAO;
        this.editor = editor;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDAO.findByUsername(s);
    }

    @Override
    public User save(UserDTO userDTO) throws EmailExistsException {
        if (emailExist(userDTO.getUsername())) {
            throw new EmailExistsException(
                    "There is an account with that email address:"  + userDTO.getUsername());
        }
        editor.setValue(userDTO);
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getEncodedPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setToken(userDTO.getToken());
        return userDAO.save(user);
    }
    private boolean emailExist(String email) {
        User user = userDAO.findByUsername(email);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public User deleteById(long id) {
        return null;
    }

    @Override
    public User update(UserDTO userDTO, User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(long id) {
        return null;
    }

    public class EmailExistsException extends Throwable {
        public EmailExistsException(String s) {
        }
    }
}
