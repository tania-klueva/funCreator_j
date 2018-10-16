package ua.com.funCreator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.funCreator.models.Feedback;
import ua.com.funCreator.models.User;
import ua.com.funCreator.services.feedbackService.FeedbackService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/feedbacks")
    public String feedbacks(Model model) {
        User user = null;
        if (SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
                //when Anonymous Authentication is enabled
                !(SecurityContextHolder.getContext().getAuthentication()
                        instanceof AnonymousAuthenticationToken)) {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        List<Feedback> all = feedbackService.findAll().stream().sorted((o1, o2) -> o2.getDateTime().compareTo(o1.getDateTime())).collect(Collectors.toList());
        model.addAttribute("feedbacks", all);
            model.addAttribute("user", user);
            return "feedback";

    }

        @PostMapping("/feedbacks")
        public String saveFeedback (Feedback feedback){
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            feedback.setUser(user);
            feedback.setDateTime(LocalDateTime.now());
            feedbackService.save(feedback);
            return "redirect:/feedbacks";
        }

    }
