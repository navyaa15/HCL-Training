package Assignment1;

import java.util.*;

class Employee {
    int id;
    String name;
    String role;
    double basic;
    double hra;
    double bonus;

    Employee(int id, String name, String role, double basic, double hra) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.basic = basic;
        this.hra = hra;
    }

    void calculateBonus() {
        double percentage = 0;

        if (role.equalsIgnoreCase("Manager")) {
            percentage = 12;
        } else if (role.equalsIgnoreCase("Admin")) {
            percentage = 10;
        } else if (role.equalsIgnoreCase("Engineer")) {
            percentage = 12;
        } else if (role.equalsIgnoreCase("Accountant")) {
            percentage = 8;
        }

        bonus = (basic + hra) * percentage / 100;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of employees:");
        int n = sc.nextInt();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            String role = sc.next();
            double basic = sc.nextDouble();
            double hra = sc.nextDouble();

            employees[i] = new Employee(id, name, role, basic, hra);
            employees[i].calculateBonus();
        }

        // Sort employees by bonus in descending order
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (employees[i].bonus < employees[j].bonus) {
                    Employee temp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }

        // Display employee details
        for (int i = 0; i < n; i++) {
            System.out.println("Emp_id: " + employees[i].id);
            System.out.println("Name: " + employees[i].name);
            System.out.printf("Bonus: Rs. %.0f%n", employees[i].bonus);
        }

        sc.close();
    }
}