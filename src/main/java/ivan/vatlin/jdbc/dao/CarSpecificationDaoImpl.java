package ivan.vatlin.jdbc.dao;

import ivan.vatlin.jdbc.dto.CarSpecification;
import ivan.vatlin.jdbc.mappers.CarSpecificationRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarSpecificationDaoImpl implements CarSpecificationDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CarSpecification> getCarSpecifications() {
        String sql = "select * from cars_specification";
        return jdbcTemplate.query(sql, new CarSpecificationRowMapper());
    }

    public CarSpecification getCarSpecificationById(long id) {
        String sql = "select * from cars_specification where id = ?";
        return jdbcTemplate.queryForObject(sql, new CarSpecificationRowMapper(), id);
    }

    public List<CarSpecification> getCarSpecificationByBrand(String brand) {
        String sql = "select * from cars_specification where brand = ?";
        return jdbcTemplate.query(sql, new CarSpecificationRowMapper(), brand);
    }

    public List<CarSpecification> getCarSpecificationByYear(short year) {
        String sql = "select * from cars_specification where year_made = ?";
        return jdbcTemplate.query(sql, new CarSpecificationRowMapper(), year);
    }

    public long createCarSpecification(CarSpecification carSpecification) {
        String sql = "insert into cars_specification ('brand', 'model', 'year_made') values (?, ?, ?)";
        return jdbcTemplate.update(sql, new CarSpecificationRowMapper(), carSpecification.getBrand(),
                carSpecification.getModel(), carSpecification.getYearMade());
    }

    public long deleteCarSpecification(long id) {
        String sql = "delete from cars_specification where id = ?";
        return jdbcTemplate.update(sql, id);
    }
}