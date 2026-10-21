package org.example.HRMS;

public class Employee {
    private final String name;
    private final Address address;
    private final Department department;
    private final Salary salary;

    public Employee(String name, Address address, Department department, Salary salary) {
        this.name = name;
        this.address = address;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Department getDepartment() {
        return department;
    }

    public Salary getSalary() {
        return salary;
    }
}