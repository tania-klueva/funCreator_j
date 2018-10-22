package ua.com.funCreator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.funCreator.dto.OrderDTO;
import ua.com.funCreator.models.User;
import ua.com.funCreator.services.orderService.OrderService;

@Controller
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public String orders(Model model){
        User user = null;
        if (SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
                //when Anonymous Authentication is enabled
                !(SecurityContextHolder.getContext().getAuthentication()
                        instanceof AnonymousAuthenticationToken)) {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        model.addAttribute("user", user);
        return "order";
    }

    @PostMapping("/order")
    public String createOrder(OrderDTO orderDTO){
        System.out.println(orderDTO);
        if (SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
                //when Anonymous Authentication is enabled
                !(SecurityContextHolder.getContext().getAuthentication()
                        instanceof AnonymousAuthenticationToken)) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            orderService.save(orderDTO, user);
            return "redirect:/user";
        }
        return "redirect:/order";
    }
}
