package ua.com.funCreator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.funCreator.dto.OrderDTO;
import ua.com.funCreator.services.orderService.OrderService;

@Controller
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public String orders(){
        return "order";
    }

    @PostMapping("/order")
    public String createOrder(OrderDTO orderDTO){
        System.out.println(orderDTO);
        return "redirect:/order";
    }
}
