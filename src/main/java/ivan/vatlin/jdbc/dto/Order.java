package ivan.vatlin.jdbc.dto;

import ivan.vatlin.jdbc.statuses.CarStatus;
import ivan.vatlin.jdbc.statuses.OrderStatus;

public class Order {
    private long id;
    private long carId;
    private String startDate;
    private String endDate;
    private User user;
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
