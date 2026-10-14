package Streams;

import java.util.*;
import java.util.stream.*;

public class Task2 {

    record Student(String firstName, String lastName, int grade) {}

    public static void main(String[] args) {

        // 1. Create Student records
        Student s1 = new Student("Lakshit", "Teotia", 85);
        Student s2 = new Student("Rahul", "Sharma", 72);
        Student s3 = new Student("Aman", "Verma", 90);
        Student s4 = new Student("Priya", "Singh", 65);
        Student s5 = new Student("Neha", "Gupta", 95);

        // 2. Access record components
        System.out.println("Student Details:");
        System.out.println(s1.firstName());
        System.out.println(s1.lastName());
        System.out.println(s1.grade());

        // 3. Store students in a List
        List<Student> students = Arrays.asList(
                s1, s2, s3, s4, s5
        );

        // 4. Display all students
        System.out.println("\nAll Students:");
        students.forEach(System.out::println);

        // 5. Filter students with grade >= 80
        System.out.println("\nStudents with grade >= 80:");
        students.stream()
                .filter(s -> s.grade() >= 80)
                .forEach(System.out::println);

        // 6. Sort students by grade in ascending order
        System.out.println("\nSorted by Grade:");
        students.stream()
                .sorted(Comparator.comparingInt(Student::grade))
                .forEach(System.out::println);

        // 7. Sort students by grade in descending order
        System.out.println("\nDescending Grade:");
        students.stream()
                .sorted(Comparator.comparingInt(Student::grade).reversed())
                .forEach(System.out::println);

        // 8. Get only student full names using map()
        System.out.println("\nStudent Names:");
        students.stream()
                .map(s -> s.firstName() + " " + s.lastName())
                .forEach(System.out::println);

        // 9. Find the highest grade
        Student topper = students.stream()
                .max(Comparator.comparingInt(Student::grade))
                .orElse(null);

        System.out.println("\nTopper: " + topper);

        // 10. Calculate average grade
        double average = students.stream()
                .mapToInt(Student::grade)
                .average()
                .orElse(0.0);

        System.out.println("\nAverage Grade: " + average);

        // 11. Count students with grade >= 75
        long count = students.stream()
                .filter(s -> s.grade() >= 75)
                .count();

        System.out.println("\nStudents with grade >= 75: " + count);
    }
}