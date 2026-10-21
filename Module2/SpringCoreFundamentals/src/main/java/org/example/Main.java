package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Employee emp1 = ctx.getBean(Employee.class);
        emp1.display();
        Employee emp2 = ctx.getBean(Employee.class);
        emp2.display();
        System.out.println(emp1.hashCode() == emp2.hashCode());
    }
}
