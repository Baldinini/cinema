package mate.academy.controllers;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.model.ShoppingCart;
import mate.academy.model.dto.response.OrderResponseDto;
import mate.academy.service.mapper.OrderMapper;
import mate.academy.service.service.OrderService;
import mate.academy.service.service.ShoppingCartService;
import mate.academy.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(ShoppingCartService shoppingCartService,
                           UserService userService,
                           OrderService orderService,
                           OrderMapper orderMapper) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping("/complete")
    public void completeOrder(Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        String email = principal.getUsername();
        ShoppingCart shoppingCart = shoppingCartService
                .getByUser(userService.findByEmail(email).get());
        orderService.completeOrder(shoppingCart);
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersByUserId(Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        String email = principal.getUsername();
        return orderService.getOrdersHistory(userService.findByEmail(email).get())
                .stream()
                .map(orderMapper::convertToDto)
                .collect(Collectors.toList());
    }
}
