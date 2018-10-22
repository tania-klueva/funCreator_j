package ua.com.funCreator.services.orderService;

import ua.com.funCreator.dto.OrderDTO;
import ua.com.funCreator.models.UserOrder;
import ua.com.funCreator.models.User;

import java.util.List;
public interface OrderService {
    UserOrder save(OrderDTO order, User user);
    List<UserOrder> findAll();
    List<UserOrder> findByUserId(long id);

}
