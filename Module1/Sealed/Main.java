package Sealed;

public class Main {
    public static void main(String[] args) {

        Car car = new Car();
        car.display();
        car.carInfo();

        Bike bike = new Bike();
        bike.display();
        bike.bikeInfo();

        SportsBike sportsBike = new SportsBike();
        sportsBike.sportsBikeInfo();
    }
}