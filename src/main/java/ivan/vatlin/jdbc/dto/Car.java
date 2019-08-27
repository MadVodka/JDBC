package ivan.vatlin.jdbc.dto;

import ivan.vatlin.jdbc.statuses.UserStatus;

public class Car {
    private long id;
    private String brand;
    private String model;
    private int yearMade;
    private double pricePerDay;
    private String registrationNumber;
    private UserStatus userStatus;

    public long getId() {
        return id;
    }

    public Car setId(long id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Car setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public int getYearMade() {
        return yearMade;
    }

    public Car setYearMade(int yearMade) {
        this.yearMade = yearMade;
        return this;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public Car setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
        return this;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Car setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        return this;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public Car setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
        return this;
    }
}
