package ua.com.funCreator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.funCreator.models.Feedback;
import ua.com.funCreator.models.User;

import java.util.List;

public interface FeedbackDAO extends JpaRepository<Feedback, Long> {
    List<Feedback> findByUser(User user);
}
