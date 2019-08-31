package ivan.vatlin.jdbc.dao;

import ivan.vatlin.jdbc.dto.Order;
import ivan.vatlin.jdbc.mappers.OrderMapper;
import ivan.vatlin.jdbc.statuses.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Order> getAllOrders() {
//        String sql = "select o.id, cars_info.brand, cars_info.model, cars_info.year_made, o.start_date, o.end_date, o.status" +
//                " from orders o inner join (select cars.id, c_s.brand, c_s.model, c_s.year_made from cars_specification c_s " +
//                "inner join cars on c_s.id = cars.cars_spec_id) as cars_info " +
//                "on o.cars_id=cars_info.id";
        String sql = "select * from orders";
        return jdbcTemplate.query(sql, new OrderMapper());
    }

    public Order getOrderById(long id) {
//        String sql = "select o.id, cars_info.brand, cars_info.model, cars_info.year_made, o.start_date, o.end_date, o.status" +
//                " from orders o inner join" + "(select cars.id, c_s.brand, c_s.model, c_s.year_made from cars_specification c_s " +
//                "inner join cars on c_s.id = cars.cars_spec_id) as cars_info " +
//                "on o.cars_id=cars_info.id where o.users_id=?";
        String sql = "select * from orders where id = ?";
        return jdbcTemplate.queryForObject(sql, new OrderMapper(), id);
    }

    public int updateOrderStatus(long id, OrderStatus orderStatus) {
        String sql = "update orders set status = ? where id = ?";
        return jdbcTemplate.update(sql, orderStatus.toString(), id);
    }

    public int createOrder(Order order) {
        String sql = "insert into orders (start_date, end_date, users_id, cars_id, price_per_day, total_price)" +
                " values (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, order.getStartDate(), order.getEndDate(), order.getUserId(),
                order.getCarId(), order.getPricePerDay(), order.getTotalPrice());
    }
}
