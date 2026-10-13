package Module1.Lambda;
// create a airthhematic interface with a abstract method calculate and write all lambda expressions for calculator

@FunctionalInterface
interface Arithmetic {
    int calculate(int a, int b);
}

public class Main {

        // Addition
        public static void main(String[] args) {
        Arithmetic add = (a, b) -> a + b;
        System.out.println("Addition: " + add.calculate(10, 5));

        // Subtraction
        Arithmetic subtract = (a, b) -> a - b;
        System.out.println("Subtraction: " + subtract.calculate(10, 5));

        // Multiplication
        Arithmetic multiply = (a, b) -> a * b;
        System.out.println("Multiplication: " + multiply.calculate(10, 5));

        // Division
        Arithmetic divide = (a, b) -> a / b;
        System.out.println("Division: " + divide.calculate(10, 5));

        // Modulus
        Arithmetic modulus = (a, b) -> a % b;
        System.out.println("Modulus: " + modulus.calculate(10, 5));
    }
}