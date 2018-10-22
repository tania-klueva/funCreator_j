package ua.com.funCreator.services.orderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.funCreator.dao.OrderDAO;
import ua.com.funCreator.dto.OrderDTO;
import ua.com.funCreator.models.UserOrder;
import ua.com.funCreator.models.User;

import java.sql.Date;
import java.sql.Time;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public UserOrder save(OrderDTO orderDto, User user) {
        UserOrder userOrder = new UserOrder();
        userOrder.setPhone(orderDto.getPhone());
        userOrder.setAmountOfPeople(orderDto.getAmountOfPeople());
        userOrder.setDate(Date.valueOf(orderDto.getDate()));
        userOrder.setTime(Time.valueOf(orderDto.getTime()+":00"));
        userOrder.setUser(user);
        return orderDAO.save(userOrder);
    }
}
