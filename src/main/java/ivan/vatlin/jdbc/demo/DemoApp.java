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
    }

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
        printActionsBlock("All cars", allCars);

        Car carById = carService.getCarById(1);
        printActionsBlock("Some car by id", carById);

        List<Car> carsInMaintenance = carService.getCarsInMaintenance();
        printActionsBlock("Cars in maintenance", carsInMaintenance);

        double price = 78;
        List<Car> carsWithPriceGreaterThan = carService.getCarsWithPriceGreaterThan(price);
        printActionsBlock("Cars with price greater than " + price, carsWithPriceGreaterThan);

        List<Car> carsWithPriceEqual = carService.getCarsWithPriceEqual(91);
        printActionsBlock("Cars with price equal " + 91, carsWithPriceEqual);

        int updateCarPriceStatus = carService.updateCarPrice(5, 62);
        printActionsBlock("Changing price of a car",
                updateCarPriceStatus > 0 ? "Price of the car with id 5 has been updated to 62" :
                        "No such a car");

//        Car car = new Car();
//        CarSpecification carSpecification = new CarSpecification();
//        carSpecification.setId(13);
//        car.setCarSpecification(carSpecification)
//                .setPricePerDay(140)
//                .setRegistrationNumber("им423е");
//        int addCarStatus = carService.addCar(car);
//        printActionsBlock("Adding a car", addCarStatus > 0 ? car + " has been added" :
//                car + " has not been added");

        int removeCarStatus = carService.removeCar(7);
        printActionsBlock("Removing a car", removeCarStatus > 0 ? "Car 7 has been removed" :
                "No such a car");
    }

    private void actionsOnCarsSpecifications() {
        List<CarSpecification> carSpecifications = carSpecificationService.getCarSpecifications();
        printActionsBlock("All cars specifications", carSpecifications);

        CarSpecification carSpecificationById = carSpecificationService.getCarSpecificationById(15);
        printActionsBlock("Car specification by id", carSpecificationById);

        List<CarSpecification> specificationByBrand = carSpecificationService.getCarSpecificationByBrand("Audi");
        printActionsBlock("Car specifications by brand", specificationByBrand);

        List<CarSpecification> carSpecificationByYear = carSpecificationService.getCarSpecificationByYear(2014);
        printActionsBlock("Car specifications by year", carSpecificationByYear);

        CarSpecification carSpecification = new CarSpecification();
        carSpecification.setBrand("Nissan")
                .setModel("Juke")
                .setYearMade(2011);
        long createResult = carSpecificationService.createCarSpecification(carSpecification);
        printActionsBlock("Creating car specification " + carSpecification,
                createResult > 0 ? "Has been added" : "Has not been added");

        long deleteResult = carSpecificationService.deleteCarSpecification(8);
        printActionsBlock("Delete car specification id " + 8,
                deleteResult > 0 ? "Has been deleted" : "No such specification");
    }

    private void printActionsBlock(String blockName, Object resultOfAction) {
        System.out.println("------ " + blockName + " ------");
        System.out.println(resultOfAction);
        System.out.println();
    }
}
