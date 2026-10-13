
package Exception;

public class Throw {

    public static void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be at least 18.");
        }
        System.out.println("Age is valid.");
    }

    public static void main(String[] args) {
        int age = args.length > 0 ? Integer.parseInt(args[0]) : 16;

        try {
            validateAge(age);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}
