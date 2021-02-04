package mate.academy.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import mate.academy.dao.OrdersDao;
import mate.academy.lib.Inject;
import mate.academy.lib.Service;
import mate.academy.model.Orders;
import mate.academy.model.ShoppingCart;
import mate.academy.model.User;
import mate.academy.service.OrdersService;
import mate.academy.service.ShoppingCartService;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Inject
    private OrdersDao ordersDao;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public Orders completeOrder(ShoppingCart shoppingCart) {
        Orders orders = new Orders();
        orders.setTickets(new ArrayList<>(shoppingCart.getTickets()));
        orders.setUser(shoppingCart.getUser());
        orders.setOrderTime(LocalDateTime.now());
        ordersDao.add(orders);
        shoppingCartService.clear(shoppingCart);
        return orders;
    }

    @Override
    public List<Orders> getOrdersHistory(User user) {
        return ordersDao.getOrdersHistory(user);
    }
}
