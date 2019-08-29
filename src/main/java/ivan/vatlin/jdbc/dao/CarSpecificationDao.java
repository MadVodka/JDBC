package ivan.vatlin.jdbc.dao;

import ivan.vatlin.jdbc.dto.CarSpecification;

import java.util.List;

public interface CarSpecificationDao {
    List<CarSpecification> getCarSpecifications();

    CarSpecification getCarSpecificationById(long id);

    List<CarSpecification> getCarSpecificationByBrand(String brand);

    List<CarSpecification> getCarSpecificationByYear(int year);

    long createCarSpecification(CarSpecification carSpecification);

    long deleteCarSpecification(long id);
}
