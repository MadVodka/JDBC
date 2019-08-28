package ivan.vatlin.jdbc.dao;

import ivan.vatlin.jdbc.dto.Car;
import ivan.vatlin.jdbc.statuses.CarStatus;

import java.util.List;

public interface CarDao {
    List<Car> getAllCars();

    Car getCarById(long id);

    Car getCarByRegNumber(String regNumber);

    List<Car> getCarsByStatus(CarStatus carStatus);

    List<Car> getCarsWithPriceEqual(double price);

    List<Car> getCarsWithPriceGreaterThan(double price);

    List<Car> getCarsWithPriceLessThan(double price);

    long addCar(Car car);

    long removeCar(long id);
}
