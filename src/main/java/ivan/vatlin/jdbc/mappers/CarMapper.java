package ivan.vatlin.jdbc.mappers;

import ivan.vatlin.jdbc.dto.Car;
import ivan.vatlin.jdbc.dto.CarSpecification;
import ivan.vatlin.jdbc.statuses.CarStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {
    public Car mapRow(ResultSet resultSet, int i) throws SQLException {
        Car car = new Car();
        CarSpecification carSpecification = new CarSpecification();

        carSpecification.setBrand(resultSet.getString("brand"))
                .setModel(resultSet.getString("model"))
                .setYearMade(resultSet.getShort("year_made"));

        car.setId(resultSet.getLong("id"))
                .setCarSpecification(carSpecification)
                .setPricePerDay(resultSet.getDouble("price_per_day"))
                .setRegistrationNumber(resultSet.getString("reg_number"))
                .setCarStatus(CarStatus.valueOf(resultSet.getString("status")));

        return car;
    }
}
