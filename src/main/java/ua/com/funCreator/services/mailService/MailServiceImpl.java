package ua.com.funCreator.services.mailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ua.com.funCreator.dto.UserDTO;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailServiceImpl implements MailService {
    private final JavaMailSender mailSender;

    @Autowired
    public MailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }



    @Override
    public void sendConfirmMessage(UserDTO user) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message);
        messageHelper.setText("<h2>Nice to meet you "+ user.getFirstName()+"!</h2><hr>" +
                "<a style=\"display:block, background:green, height:100px\" href=\"http://localhost:8080/confirm/"+user.getToken() +"\">"+
                "Please confirm your account!</a>", true);
        messageHelper.setSubject("Confirm your account!");
        messageHelper.setTo(user.getUsername());
        mailSender.send(message);
    }

    @Override
    public void sendEmailConfirmMessage(UserDTO user) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message);
        messageHelper.setText("<h2>Nice to meet you "+ user.getFirstName()+"!</h2><hr>" +
                "<a style=\"display:block, background:green, height:100px\" href=\"http://localhost:8080/confirm/"+ user.getUsername() + "/" +user.getToken() +"\">"+
                "Please confirm your email!</a>", true);
        messageHelper.setSubject("Confirm your email!");
        messageHelper.setTo(user.getUsername());
        mailSender.send(message);
    }

    @Override
    public void sendMessageWithAttachment(String email, String subject, String text, MultipartFile file) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setText(text);
        messageHelper.setSubject(subject);
        messageHelper.addAttachment( file.getOriginalFilename() ,file);
        messageHelper.setTo(email);
        mailSender.send(message);
    }


}
