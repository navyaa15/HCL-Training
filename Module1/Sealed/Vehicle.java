package Sealed;

public sealed class Vehicle permits Car, Bike {

    public void display() {
        System.out.println("This is a vehicle");
    }
}