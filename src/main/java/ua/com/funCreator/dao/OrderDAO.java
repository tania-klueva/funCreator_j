package ua.com.funCreator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.funCreator.models.Order;
@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {
}
