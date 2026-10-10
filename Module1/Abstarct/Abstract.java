package Abstarct;

abstract class Animal{
    abstract void sound();
    void sleep(){
        System.out.println("Animal is sleeping");
    }
}
class Dog extends Animal{
    void sound(){
        System.out.println("Dog says: Wolf!");
    }
}
public class Abstract {
    public static void main(String[] args){
        Animal animal = new Dog();
        animal.sound();
        animal.sleep();
    }
}

