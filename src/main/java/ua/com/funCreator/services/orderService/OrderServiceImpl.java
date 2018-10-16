package ua.com.funCreator.services.orderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.funCreator.dao.OrderDAO;
import ua.com.funCreator.models.Order;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public Order save(Order order) {
        return orderDAO.save(order);
    }
}
