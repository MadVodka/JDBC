package ivan.vatlin.jdbc.services;

import ivan.vatlin.jdbc.dto.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();

    Car getCarById(long id);

    Car getCarByRegNumber(String regNumber);

    List<Car> getCarsInUse();

    List<Car> getCarsInMaintenance();

    List<Car> getCarsWithPriceEqual(double price);

    List<Car> getCarsWithPriceGreaterThan(double price);

    List<Car> getCarsWithPriceLessThan(double price);

    int addCar(Car car);

    int removeCar(long id);

    int updateCarPrice(long id, double price);
}
