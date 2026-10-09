package Abstarct;

import java.util.ArrayList;

public class Array {
    public static void main(String[] args) {
        // 1. ArrayList create karein
        ArrayList<String> list = new ArrayList<>();

        // 2. 10 elements add karein
        for (int i = 1; i <= 10; i++) {
            list.add("Element " + i);
        }

        // 3. 2 elements update karein (Index 2 aur Index 5 ko change kar rahe hain)
        String newElement1 = "Updated Element 3";
        String newElement2 = "Updated Element 6";

        list.set(2, newElement1); // Index 2 (3rd element)
        list.set(5, newElement2); // Index 5 (6th element)

        // 4. Sirf updated wale elements print karein
        System.out.println("--- Updated Elements ---");
        System.out.println("Index 2 par naya element: " + list.get(2));
        System.out.println("Index 5 par naya element: " + list.get(5));

        // 5. Pura ArrayList print karein
        System.out.println("\n--- Complete ArrayList ---");
        System.out.println(list);
    }
}