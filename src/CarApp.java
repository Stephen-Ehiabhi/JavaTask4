class Car{
    private String model;
    private String brand;
    private int year;
    private String color;
    private double quantity;
    private double price;


    public Car(String model, String brand, int year, double price, String color, int quantity) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getQuantity() {
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
        Car car1 = new Car("Tesla","tesla motors",2014,20000.00,"grey",500);
        Car car2 = new Car("Lamborghini","toyota",2015,40000.00,"white",200);

        System.out.println(car1.toString());
        System.out.println(car2.toString());

        car1.sell(300);
        car1.setColor("green");
        car2.delivery(2000);

        System.out.println("");
        System.out.println(car1.toString());
        car2.delivery(1000);
        car2.setColor("grey");
        System.out.println(car2.toString());
    }
}