package Streams;


import java.util.*;
import java.util.stream.*;

public class Task {

    static class Employee {
        String name;
        String department;
        double salary;
        int age;

        Employee(String name, String department, double salary) {
            this(name, department, salary, 0);
        }

        Employee(String name, String department, double salary, int age) {
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.age = age;
        }

        public double getSalary() {
            return salary;
        }

        public String getDepartment() {
            return department;
        }

        public int getAge() {
            return age;
        }

        public String toString() {
            return name + " - " + salary;
        }
    }

    public static void main(String[] args) {

        // Task 1: Names starting with A
        List<String> names = Arrays.asList(
                "Aman", "Rahul", "Ankit",
                "Priya", "Aditi", "Rohit"
        );

        List<String> result = names.stream()
                .filter(n -> n.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Task 1: " + result);

        // Employee data
        List<Employee> employees = Arrays.asList(
                new Employee("Aman", "IT", 50000, 25),
                new Employee("Rahul", "HR", 40000, 30),
                new Employee("Ankit", "IT", 70000, 35),
                new Employee("Priya", "HR", 60000, 28),
                new Employee("Aman", "Sales", 80000, 32)
        );

        // Task 2: Total salary per department
        Map<String, Double> salaryByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.summingDouble(
                                        Employee::getSalary
                                )
                        ));

        System.out.println("Task 2: " + salaryByDept);

        // Task 3: Top 3 highest paid employees
        List<Employee> top3 = employees.stream()
                .sorted(Comparator.comparingDouble(
                        Employee::getSalary
                ).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Task 3: " + top3);

        // Task 4: Sort employees by age
        List<Employee> sortedByAge = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .collect(Collectors.toList());

        System.out.println("Task 4: " + sortedByAge);

        // Task 5: Word frequency
        String text = "java python java sql python java";

        Map<String, Long> frequency =
                Arrays.stream(text.split("\\s+"))
                        .collect(Collectors.groupingBy(
                                w -> w,
                                Collectors.counting()
                        ));

        System.out.println("Task 5: " + frequency);
    }
}