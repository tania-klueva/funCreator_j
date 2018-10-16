package ua.com.funCreator.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ua.com.funCreator.dto.UserDTO;

import java.beans.PropertyEditorSupport;
import java.util.UUID;

@Component
public class UserEditor extends PropertyEditorSupport {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserEditor(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void setValue(Object value) {
        UserDTO user = (UserDTO) value;
        user.setEncodedPassword(passwordEncoder.encode(user.getPassword()));
        user.setToken(UUID.randomUUID().toString());
    }
}
