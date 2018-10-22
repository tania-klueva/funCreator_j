package ua.com.funCreator.services.orderService;

import ua.com.funCreator.dto.OrderDTO;
import ua.com.funCreator.models.UserOrder;
import ua.com.funCreator.models.User;

public interface OrderService {
    UserOrder save(OrderDTO order, User user);
}
