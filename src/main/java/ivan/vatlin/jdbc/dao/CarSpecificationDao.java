package ivan.vatlin.jdbc.dao;

import ivan.vatlin.jdbc.dto.CarSpecification;

import java.util.List;

public interface CarSpecificationDao {
    List<CarSpecification> getCarSpecifications();

    CarSpecification getCarSpecificationById(long id);

    CarSpecification getCarSpecificationByWholeInfo(CarSpecification carSpecification);

    List<CarSpecification> getCarSpecificationByBrand(String brand);

    List<CarSpecification> getCarSpecificationByYear(int year);

    int createCarSpecification(CarSpecification carSpecification);

    int deleteCarSpecification(long id);
}
