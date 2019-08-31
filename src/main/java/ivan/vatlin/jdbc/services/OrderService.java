package ivan.vatlin.jdbc.services;

import ivan.vatlin.jdbc.dto.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    Order getOrderById(long id);

    int approveOrder(long id);

    int denyOrder(long id);

    int createOrder(Order order);

}
