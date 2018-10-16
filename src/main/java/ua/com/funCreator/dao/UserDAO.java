package ua.com.funCreator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.funCreator.models.User;
@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByToken(long token);
}
