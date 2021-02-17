package mate.academy.controllers;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.model.ShoppingCart;
import mate.academy.model.User;
import mate.academy.model.dto.response.OrderResponseDto;
import mate.academy.service.mapper.OrderMapper;
import mate.academy.service.service.OrderService;
import mate.academy.service.service.ShoppingCartService;
import mate.academy.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public void completeOrder(@RequestParam Long userId) {
        ShoppingCart shoppingCart = shoppingCartService.getByUser(userService.getById(userId));
        orderService.completeOrder(shoppingCart);
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersByUserId(@RequestParam Long userId) {
        User user = userService.getById(userId);
        return orderService.getOrdersHistory(user)
                .stream()
                .map(orderMapper::convertToDto)
                .collect(Collectors.toList());
    }
}
