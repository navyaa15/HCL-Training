
package Module1.Array;

import java.util.*;

class Student {
    String name;
    int rollno;
    int age;
    double marks;

    public Student(String name, int rollno, int age, double marks) {
        this.name = name;
        this.rollno = rollno;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Name: " + name
                + ", Roll No: " + rollno
                + ", Age: " + age
                + ", Marks: " + marks;
    }
}

public class Task1 {
    public static void main(String[] args) {

        List<Student> ls = new ArrayList<>(10);

        ls.add(new Student("Rahul", 101, 20, 85.5));
        ls.add(new Student("Aman", 102, 19, 90.0));
        ls.add(new Student("Priya", 103, 21, 88.5));
        ls.add(new Student("Neha", 104, 18, 92.0));
        ls.add(new Student("Rohit", 105, 20, 75.0));
        ls.add(new Student("Anjali", 106, 19, 95.0));
        ls.add(new Student("Karan", 107, 22, 80.5));
        ls.add(new Student("Sneha", 108, 18, 89.0));
        ls.add(new Student("Vikas", 109, 21, 78.5));
        ls.add(new Student("Pooja", 110, 20, 91.0));

        // Original Student List
        System.out.println("Original Student List");
        for (Student s : ls) {
            System.out.println(s);
        }

        // Sort by age (ascending)
        Collections.sort(ls, Comparator.comparingInt(s -> s.age));

        System.out.println("\nSorted by Age");
        for (Student s : ls) {
            System.out.println(s);
        }

        // Sort by marks (ascending)
        Collections.sort(ls, Comparator.comparingDouble(s -> s.marks));

        System.out.println("\nSorted by Marks");
        for (Student s : ls) {
            System.out.println(s);
        }
    }
}
