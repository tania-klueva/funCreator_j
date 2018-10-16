package ua.com.funCreator.services.feedbackService;

import ua.com.funCreator.models.Feedback;
import ua.com.funCreator.models.User;

import java.util.List;

public interface FeedbackService {
    Feedback save(Feedback feedback);
    void deleteById(long id);
    Feedback findById(long id);
    List<Feedback> findAll();
    List<Feedback> findByUser(User user);
}
