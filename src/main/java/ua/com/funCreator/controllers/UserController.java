package ua.com.funCreator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.funCreator.dto.UserDTO;
import ua.com.funCreator.models.User;
import ua.com.funCreator.models.UserOrder;
import ua.com.funCreator.services.mailService.MailService;
import ua.com.funCreator.services.orderService.OrderService;
import ua.com.funCreator.services.userService.UserService;
import ua.com.funCreator.services.userService.UserServiceImpl;
import ua.com.funCreator.utils.UserValidator;

import javax.mail.MessagingException;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;
    private final MailService mailService;
    private final OrderService orderService;

    @Autowired
    public UserController(UserService userService, UserValidator userValidator, MailService mailService, OrderService orderService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.mailService = mailService;
        this.orderService = orderService;
    }

    @GetMapping("/user")
    public String userProfile(Model model) {
        User user = null;
        if (SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
                //when Anonymous Authentication is enabled
                !(SecurityContextHolder.getContext().getAuthentication()
                        instanceof AnonymousAuthenticationToken)) {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<UserOrder> orders = orderService.findByUserId(user.getId());
            model.addAttribute("user", user);
            model.addAttribute("orders", orders);

            return "user";
        } else {
            return "redirect:/singin";
        }
    }

    @GetMapping("/signin")
    public String signIn(Model model) {
        if (SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
                !(SecurityContextHolder.getContext().getAuthentication()
                        instanceof AnonymousAuthenticationToken)) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return "redirect:/user";
        }
        return "signin";
    }


    @GetMapping("/signup")
    public String signUpUser(Model model) {
        if (SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
                //when Anonymous Authentication is enabled
                !(SecurityContextHolder.getContext().getAuthentication()
                        instanceof AnonymousAuthenticationToken)) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return "redirect:/user";
        }
        model.addAttribute("error", null);
        return "signup";
    }

    @PostMapping("/signup")
    public String saveUser(UserDTO userDTO, BindingResult result, Model model) {
        userValidator.validate(userDTO, result);
        if (!result.hasErrors()) {

            try {
                userService.save(userDTO);
            } catch (UserServiceImpl.EmailExistsException e) {
                result.rejectValue("username", "Email already exist");
            }
        }
        if (result.hasErrors()) {

            String errorMessage = "";
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError allError : allErrors) {
                errorMessage += allError.toString();
            }

            model.addAttribute("error", errorMessage);
            return "signup";
        }

        try {
            mailService.sendConfirmMessage(userDTO);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return "redirect:/signin";
    }
}
