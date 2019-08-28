package ivan.vatlin.jdbc.dto;

public class CarSpecification {
    private long id;
    private String brand;
    private String model;
    private short yearMade;

    public long getId() {
        return id;
    }

    public CarSpecification setId(long id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CarSpecification setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarSpecification setModel(String model) {
        this.model = model;
        return this;
    }

    public short getYearMade() {
        return yearMade;
    }

    public CarSpecification setYearMade(short yearMade) {
        this.yearMade = yearMade;
        return this;
    }

    @Override
    public String toString() {
        return "CarSpecification{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearMade=" + yearMade +
                '}';
    }
}
