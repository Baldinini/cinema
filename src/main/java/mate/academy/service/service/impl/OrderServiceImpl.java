package mate.academy.service.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import mate.academy.dao.OrderDao;
import mate.academy.model.Order;
import mate.academy.model.ShoppingCart;
import mate.academy.model.User;
import mate.academy.service.service.OrderService;
import mate.academy.service.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, ShoppingCartService shoppingCartService) {
        this.orderDao = orderDao;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setTickets(new ArrayList<>(shoppingCart.getTickets()));
        order.setUser(shoppingCart.getUser());
        order.setOrderTime(LocalDateTime.now());
        orderDao.add(order);
        shoppingCartService.clear(shoppingCart);
        return order;
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getOrdersHistory(user);
    }
}
