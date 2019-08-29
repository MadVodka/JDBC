package ivan.vatlin.jdbc.dao;

import ivan.vatlin.jdbc.dto.Order;
import ivan.vatlin.jdbc.statuses.OrderStatus;

import java.util.List;

public interface OrderDao {
    List<Order> getAllOrders();

    Order getOrderById(long id);

    int updateOrderStatus(long id, OrderStatus orderStatus);

    int createOrder(Order order);
}
