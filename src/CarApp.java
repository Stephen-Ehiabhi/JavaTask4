class Car{
    private String model;
    private String brand;
    private int year;
    private String color;
    private float quantity;
    private float price;


    public Car(String model, String brand, int year, int price, String color, int quantity) {
        this.model = model;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public void sell(int sold) {
        quantity -= sold;
    }

    public void delivery(int delivery) {
        quantity -= delivery;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}




public class CarApp{
    public static void main(String[] args) {
        Car cr = new Car("3000", "Tesla", 2021, 300000, "grey", 20);

        System.out.println(cr.toString());
        cr.sell(10);

        System.out.println(cr.getColor());
        cr.setColor("Blue");

        int year = cr.getYear();
        cr.setYear(2022);

        System.out.println(cr.getModel());
        System.out.println(cr.getQuantity());
        System.out.println(cr.toString());
        System.out.println(cr.getBrand());
        System.out.println(cr.getPrice());
    }
}