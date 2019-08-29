package ivan.vatlin.jdbc.dto;

import ivan.vatlin.jdbc.statuses.CarStatus;
import ivan.vatlin.jdbc.statuses.OrderStatus;

public class Order {
    private long id;
    private long carId;
    private String startDate;
    private String endDate;
    private long userId;

    private OrderStatus orderStatus;

    private double pricePerDay;
    private double totalPrice;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public long getUserId() {
        return userId;
    }

    public Order setUserId(long userId) {
        this.userId = userId;
        return this;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Order setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public Order setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
        return this;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Order setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", carId=" + carId +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
