package ua.com.funCreator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.funCreator.models.UserOrder;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<UserOrder, Long> {

    List<UserOrder> findByUserId(long id);
}
