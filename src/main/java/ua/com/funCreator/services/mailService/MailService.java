package ua.com.funCreator.services.mailService;

import org.springframework.web.multipart.MultipartFile;
import ua.com.funCreator.dto.UserDTO;

import javax.mail.MessagingException;

public interface MailService {
    void sendConfirmMessage(UserDTO user) throws MessagingException;
    void sendEmailConfirmMessage(UserDTO user) throws MessagingException;
    void sendMessageWithAttachment(String email, String subject, String text, MultipartFile file) throws MessagingException;
}
