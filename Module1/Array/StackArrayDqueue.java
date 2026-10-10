package Array;

import java.util.ArrayDeque;

public class StackArrayDqueue {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack: " + stack);

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());

        System.out.println("Contains 10: " + stack.contains(10));

        System.out.println("Stack size: " + stack.size());

        System.out.println("Is empty: " + stack.isEmpty());

        System.out.println("Stack elements:");
        for (int element : stack) {
            System.out.println(element);
        }

        stack.clear();
        System.out.println("After clear: " + stack);
    }
}