package ivan.vatlin.jdbc.demo;

import ivan.vatlin.jdbc.dto.Car;
import ivan.vatlin.jdbc.dto.CarSpecification;
import ivan.vatlin.jdbc.dto.User;
import ivan.vatlin.jdbc.dto_helpers.UserRole;
import ivan.vatlin.jdbc.services.CarService;
import ivan.vatlin.jdbc.services.CarSpecificationService;
import ivan.vatlin.jdbc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemoApp {
    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @Autowired
    private CarSpecificationService carSpecificationService;

    public void run() {
        System.out.println("##### Actions with users #####");
        actionsOnUsers();
        System.out.println();
//        System.out.println("##### Actions with cars #####");
//        actionsOnCars();
        System.out.println("##### Actions with car specifications #####");
        actionsOnCarsSpecifications();
        System.out.println();
        System.out.println("##### Actions with cars #####");
        actionsOnCars();
    }

    // доработать удаление юзера (проверить в ордерах)
    private void actionsOnUsers() {
        List<User> allUsers = userService.getAllUsers();
        printActionsBlock("All users",
                allUsers.isEmpty() ? "Users not found" : allUsers);

        List<User> orderedUsers = userService.getOrderedUsers();
        printActionsBlock("Ordered users",
                orderedUsers.isEmpty() ? "Users not found" : orderedUsers);

        long id = 1;
        User userById = userService.getUserById(id);
        printActionsBlock("Some user by id",
                userById == null ? "User with id " + id + " not found" : userById);

        List<User> admins = userService.getAdmins();
        printActionsBlock("Users with admin role",
                admins.isEmpty() ? "Users not found" : admins);

        User user = new User();
        user.setUserName("igorIgor")
                .setFirstName("Игорь")
                .setSecondName("Великий")
                .setUserRole(UserRole.CLIENT);
        int userCreationResult = userService.createUser(user);
        printActionsBlock("Create a new user as client",
                user + (userCreationResult > 0 ? " created" : " can't be created. Check use other username"));

        long blockUserId = 16;
        int blockUserResult = userService.blockUser(blockUserId);
        printActionsBlock("Block a user",
                "User id " + blockUserId + (blockUserResult > 0 ? " blocked" : " can't be blocked"));

        long activateUserId = 16;
        int activateUserResult = userService.activateUser(activateUserId);
        printActionsBlock("Activate a user",
                "User id " + activateUserId + (activateUserResult > 0 ? " activated" : " can't be activated"));


        long deleteUserId = 1;
        int deleteUserResult = userService.deleteUser(1);
        printActionsBlock("Delete a user",
                "User id " + deleteUserId + (deleteUserResult > 0 ? " deleted" : " can't be deleted"));
    }

    private void actionsOnCars() {
        List<Car> allCars = carService.getAllCars();
        printActionsBlock("All cars", allCars.isEmpty() ? "Not found" : allCars);

        Car carById = carService.getCarById(1);
        printActionsBlock("Some car by id", carById == null ? "Not found" : carById);

        List<Car> carsInMaintenance = carService.getCarsInMaintenance();
        printActionsBlock("Cars in maintenance",
                carsInMaintenance.isEmpty() ? "Not found" : carsInMaintenance);

        double priceGreaterThan = 78;
        List<Car> carsWithPriceGreaterThan = carService.getCarsWithPriceGreaterThan(priceGreaterThan);
        printActionsBlock("Cars with price greater than " + priceGreaterThan,
                carsWithPriceGreaterThan.isEmpty() ? "Not found" : carsWithPriceGreaterThan);

        double priceEqual = 91;
        List<Car> carsWithPriceEqual = carService.getCarsWithPriceEqual(priceEqual);
        printActionsBlock("Cars with price equal " + priceEqual,
                carsWithPriceEqual.isEmpty() ? "Not found" : carsWithPriceEqual);

        long carId = 5;
        double priceUpdate = 62;
        int updateCarPriceStatus = carService.updateCarPrice(carId, priceUpdate);
        printActionsBlock("Changing price to " + priceUpdate + " of the car with id " + carId,
                updateCarPriceStatus > 0 ? "Updated" :
                        "Can't update price");

        Car car = new Car();
        CarSpecification carSpecification = new CarSpecification();
        carSpecification.setId(20);
        car.setCarSpecification(carSpecification)
                .setPricePerDay(140)
                .setRegistrationNumber("оо456о");
        int addCarStatus = carService.addCar(car);
        String result;
        if (addCarStatus > 0) {
            result = "added";
        } else if (addCarStatus == -1) {
            result = "registration number must be unique";
        } else {
            result = "used car specification doesn't exist";
        }
        printActionsBlock("Adding a car " + car, result);

        int removeId = 7;
        int removeCarStatus = carService.removeCar(removeId);
        printActionsBlock("Removing the car with id " + removeId,
                removeCarStatus > 0 ? "Removed" : "Can't remove a car (No such a car)");
    }

    private void actionsOnCarsSpecifications() {
        List<CarSpecification> carSpecifications = carSpecificationService.getCarSpecifications();
        printActionsBlock("All cars specifications",
                carSpecifications == null ? "Not found" : carSpecifications);

        long id = 15;
        CarSpecification carSpecificationById = carSpecificationService.getCarSpecificationById(id);
        printActionsBlock("Car specification by id " + id,
                carSpecificationById == null ? " not found" : carSpecificationById);

        String brand = "Audi";
        List<CarSpecification> specificationByBrand = carSpecificationService.getCarSpecificationByBrand(brand);
        printActionsBlock("Car specifications (brand " + brand + ")",
                specificationByBrand == null ? "not found" : specificationByBrand);

        int year = 2014;
        List<CarSpecification> carSpecificationByYear = carSpecificationService.getCarSpecificationByYear(2014);
        printActionsBlock("Car specifications (year " + year + ")",
                carSpecificationByYear == null ? "not found" : carSpecificationByYear);

        CarSpecification carSpecification = new CarSpecification();
        carSpecification.setBrand("Nissan")
                .setModel("Juke")
                .setYearMade(2011);
        int createResult = carSpecificationService.createCarSpecification(carSpecification);
        printActionsBlock("Creating car specification " + carSpecification,
                createResult > 0 ? "added" : "can't be added (already exists)");

        long deleteId = 8;
        int deleteResult = carSpecificationService.deleteCarSpecification(deleteId);
        printActionsBlock("Delete car specification id " + deleteId,
                deleteResult > 0 ? "deleted" : "can't be deleted (no such car specification)");
    }

    private void actionsOnOrders() {

    }

    private void printActionsBlock(String blockName, Object resultOfAction) {
        System.out.println("------ " + blockName + " ------");
        System.out.println(resultOfAction);
        System.out.println();
    }
}
