package ivan.vatlin.jdbc.dao;

import ivan.vatlin.jdbc.dto.Car;
import ivan.vatlin.jdbc.mappers.CarMapper;
import ivan.vatlin.jdbc.statuses.CarStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Car> getAllCars() {
        String sql = "select c.id, cs.brand, cs.model, cs.year_made, c.reg_number, cs.price_per_day, c.status " +
                "from cars as c inner join cars_specification as cs on c.cars_spec_id = cs.id";
        return jdbcTemplate.query(sql, new CarMapper());
    }

    public Car getCarById(long id) {
        String sql = "select c.id, cs.brand, cs.model, cs.year_made, c.reg_number, cs.price_per_day, c.status " +
                "from cars as c inner join cars_specification as cs on c.cars_spec_id = cs.id where c.id = ?";
        return jdbcTemplate.queryForObject(sql, new CarMapper(), id);
    }

    public Car getCarByRegNumber(String regNumber) {
        String sql = "select c.id, cs.brand, cs.model, cs.year_made, c.reg_number, cs.price_per_day, c.status " +
                "from cars as c inner join cars_specification as cs on c.cars_spec_id = cs.id where c.reg_number = ?";
        return jdbcTemplate.queryForObject(sql, new CarMapper(), regNumber);
    }

    public List<Car> getCarsByStatus(CarStatus carStatus) {
        String sql = "select c.id, cs.brand, cs.model, cs.year_made, c.reg_number, cs.price_per_day, c.status " +
                "from cars as c inner join cars_specification as cs on c.cars_spec_id = cs.id where c.status = ?";
        return jdbcTemplate.query(sql, new CarMapper(), carStatus.toString());
    }

    public List<Car> getCarsWithPriceEqual(double price) {
        String sql = "select c.id, cs.brand, cs.model, cs.year_made, c.reg_number, cs.price_per_day, c.status " +
                "from cars as c inner join cars_specification as cs on c.cars_spec_id = cs.id where c.price_per_day = ?";
        return jdbcTemplate.query(sql, new CarMapper(), price);
    }

    public List<Car> getCarsWithPriceGreaterThan(double price) {
        String sql = "select c.id, cs.brand, cs.model, cs.year_made, c.reg_number, cs.price_per_day, c.status " +
                "from cars as c inner join cars_specification as cs on c.cars_spec_id = cs.id where c.price_per_day > ?";
        return jdbcTemplate.query(sql, new CarMapper(), price);
    }

    public List<Car> getCarsWithPriceLessThan(double price) {
        String sql = "select c.id, cs.brand, cs.model, cs.year_made, c.reg_number, cs.price_per_day, c.status " +
                "from cars as c inner join cars_specification as cs on c.cars_spec_id = cs.id where c.price_per_day < ?";
        return jdbcTemplate.query(sql, new CarMapper(), price);
    }

    public long addCar(Car car) {
        String sql = "insert into cars (cars_spec_id, price_per_day, reg_number) values (?, ?, ?)";
        return jdbcTemplate.update(sql, car.getCarSpecification().getId(), car.getPricePerDay(),
                car.getRegistrationNumber());
    }

    public long removeCar(long id) {
        String sql = "delete from cars where id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
