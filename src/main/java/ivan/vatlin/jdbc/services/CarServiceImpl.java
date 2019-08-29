package ivan.vatlin.jdbc.services;

import ivan.vatlin.jdbc.dao.CarDao;
import ivan.vatlin.jdbc.dto.Car;
import ivan.vatlin.jdbc.statuses.CarStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }

    public Car getCarById(long id) {
        return carDao.getCarById(id);
    }

    public Car getCarByRegNumber(String regNumber) {
        return carDao.getCarByRegNumber(regNumber);
    }

    public List<Car> getCarsInUse() {
        return carDao.getCarsByStatus(CarStatus.IN_USE);
    }

    public List<Car> getCarsInMaintenance() {
        return carDao.getCarsByStatus(CarStatus.IN_MAINTAINANCE);
    }

    public List<Car> getCarsWithPriceEqual(double price) {
        return carDao.getCarsWithPriceEqual(price);
    }

    public List<Car> getCarsWithPriceGreaterThan(double price) {
        return carDao.getCarsWithPriceGreaterThan(price);
    }

    public List<Car> getCarsWithPriceLessThan(double price) {
        return carDao.getCarsWithPriceLessThan(price);
    }

    public int addCar(Car car) {
        return carDao.addCar(car);
    }

    public int removeCar(long id) {
        return carDao.removeCar(id);
    }

    public int updateCarPrice(long id, double price) {
        return carDao.updateCarPrice(id, price);
    }
}
