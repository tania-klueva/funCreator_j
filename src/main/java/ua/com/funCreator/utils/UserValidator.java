package ua.com.funCreator.utils;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.com.funCreator.dto.UserDTO;
import ua.com.funCreator.models.User;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDTO userDTO = (UserDTO) o;
        if (userDTO.getUsername().length() < 3) {
            errors.rejectValue("username","message.length.error");
        }else if (userDTO.getPassword().length() < 6){
            errors.rejectValue("password","message.length.error");
        }
    }
}
