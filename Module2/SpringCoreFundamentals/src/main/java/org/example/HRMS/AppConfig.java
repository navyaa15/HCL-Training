package org.example.HRMS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Address address() {
        return new Address("Crossing Republik, Ghaziabad");
    }

    @Bean
    public Department department() {
        return new Department("Human Resources");
    }

    @Bean
    public Salary salary() {
        return new Salary(50000, 10000, 15000);
    }

    @Bean
    public Employee employee(Address address, Department department, Salary salary) {
        return new Employee("Employee One", address, department, salary);
    }
}