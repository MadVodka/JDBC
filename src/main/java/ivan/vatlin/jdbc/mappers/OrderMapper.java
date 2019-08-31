package ivan.vatlin.jdbc.mappers;

import ivan.vatlin.jdbc.dto.Order;
import ivan.vatlin.jdbc.statuses.OrderStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();

        order.setUserId(rs.getLong("id"))
                .setCarId(rs.getLong("cars_id"))
                .setUserId(rs.getLong("users_id"))
                .setStartDate(rs.getString("start_date"))
                .setEndDate(rs.getString("end_date"))
                .setPricePerDay(rs.getDouble("price_per_day"))
                .setTotalPrice(rs.getDouble("total_price"))
                .setOrderStatus(OrderStatus.valueOf(rs.getString("status")));

        return order;
    }
}
