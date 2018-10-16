package ua.com.funCreator.services.feedbackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.funCreator.dao.FeedbackDAO;
import ua.com.funCreator.models.Feedback;
import ua.com.funCreator.models.User;

import java.util.List;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackDAO feedbackDAO;

    @Autowired
    public FeedbackServiceImpl(FeedbackDAO feedbackDAO) {
        this.feedbackDAO = feedbackDAO;
    }

    @Override
    public Feedback save(Feedback feedback) {
        return feedbackDAO.save(feedback);
    }

    @Override
    public void deleteById(long id) {
        feedbackDAO.delete(id);
    }


    @Override
    public Feedback findById(long id) {
        return feedbackDAO.findOne(id);
    }

    @Override
    public List<Feedback> findAll() {
        return feedbackDAO.findAll();
    }

    @Override
    public List<Feedback> findByUser(User user) {
        return feedbackDAO.findByUser(user);
    }
}
