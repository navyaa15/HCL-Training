package org.example.HRMS;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main  {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Employee employee = context.getBean(Employee.class);
        System.out.println(employee.getName()
                + " address: " + employee.getAddress().getAddressLine()
                + ", department: " + employee.getDepartment().getName()
                + ", salary: basic=" + employee.getSalary().getBasic()
                + ", DA=" + employee.getSalary().getDa()
                + ", HRA=" + employee.getSalary().getHra()
                + ", total=" + employee.getSalary().getTotal());
    }
}