package ivan.vatlin.jdbc.mappers;

import ivan.vatlin.jdbc.dto.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
