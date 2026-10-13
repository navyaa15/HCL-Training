package Lambda;


import java.util.function.*;

public class Main2 {
    public static void main(String[] args) {


        Predicate<Integer> evenOdd = n -> n % 2 == 0;

        System.out.println("Predicate:");
        System.out.println("10 is even: " + evenOdd.test(10));
        System.out.println("7 is even: " + evenOdd.test(7));



        Function<Integer, Integer> square = n -> n * n;

        System.out.println("\nFunction:");
        System.out.println("Square of 5: " + square.apply(5));

        Consumer<Integer> printNumber =
                n -> System.out.println("Number: " + n);

        System.out.println("\nConsumer:");
        printNumber.accept(25);



        Supplier<Integer> getNumber = () -> 100;

        System.out.println("\nSupplier:");
        System.out.println("Supplied number: " + getNumber.get());
    }
}