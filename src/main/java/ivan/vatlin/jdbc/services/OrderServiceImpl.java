package ivan.vatlin.jdbc.services;

import ivan.vatlin.jdbc.dao.OrderDao;
import ivan.vatlin.jdbc.dto.Order;
import ivan.vatlin.jdbc.statuses.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    public Order getOrderById(long id) {
        try {
            return orderDao.getOrderById(id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public int approveOrder(long id) {
        return orderDao.updateOrderStatus(id, OrderStatus.APPROVED);
    }

    public int denyOrder(long id) {
        return orderDao.updateOrderStatus(id, OrderStatus.DENIED);
    }

    public int createOrder(Order order) {
        return orderDao.createOrder(order);
    }
}
