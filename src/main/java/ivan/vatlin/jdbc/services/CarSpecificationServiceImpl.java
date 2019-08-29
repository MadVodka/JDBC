package ivan.vatlin.jdbc.services;

import ivan.vatlin.jdbc.dao.CarSpecificationDao;
import ivan.vatlin.jdbc.dto.CarSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarSpecificationServiceImpl implements CarSpecificationService {
    @Autowired
    private CarSpecificationDao carSpecificationDao;

    public List<CarSpecification> getCarSpecifications() {
        return carSpecificationDao.getCarSpecifications();
    }

    public CarSpecification getCarSpecificationById(long id) {
        return carSpecificationDao.getCarSpecificationById(id);
    }

    public List<CarSpecification> getCarSpecificationByBrand(String brand) {
        return carSpecificationDao.getCarSpecificationByBrand(brand);
    }

    public List<CarSpecification> getCarSpecificationByYear(int year) {
        return carSpecificationDao.getCarSpecificationByYear(year);
    }

    public long createCarSpecification(CarSpecification carSpecification) {
        return carSpecificationDao.createCarSpecification(carSpecification);
    }

    public long deleteCarSpecification(long id) {
        return carSpecificationDao.deleteCarSpecification(id);
    }
}
