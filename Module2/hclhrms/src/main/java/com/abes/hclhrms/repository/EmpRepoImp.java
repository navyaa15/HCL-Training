package com.abes.hclhrms.repository;

import com.abes.hclhrms.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmpRepoImp implements EmpRepo {

    List<Employee> emplist = new ArrayList<>();
    @Override
    public String addemp(Employee emp) {
        emplist.add(emp);
        return "Employee Added Successfully";
    }

    @Override
    public List<Employee> getEmp() {
        return emplist;
    }

    @Override
    public String addEmpbulk() {
        List<Employee> bulkEmployees = List.of(
                new Employee(100, "Ankush", "Student", "FSD", "ankush7380@gmail.com"),
                new Employee(101, "Ashish", "Developer", "Java", "ashish@gmail.com"),
                new Employee(102, "Amitabh", "Tester", "java", "abhay@gmail.com"),
                new Employee(103, "Isahan", "FSD", "Java", "ishan@gmail.com")
        );
        emplist.addAll(bulkEmployees);
        return bulkEmployees.size() + " employees added successfully";
    }

    @Override
    public Employee getEmpById(long empid) {
        return emplist.stream().filter(e->e.getEmp_id() == empid).findFirst().orElse(null);
    }


    @Override
    public String deleteById(long empid) {
        boolean status = false;

        if (getEmpById(empid) != null) {
            status = emplist.removeIf(e -> e.getEmp_id() == empid);
        }

        if (status) {
            return "Employee deleted successfully";
        }

        return "Employee not Regesitered";
    }


    @Override
    public String updateById(long empid, Employee updateById){
        Emoloyee emp = new Employee(
                 200,
                 "Navya",
                "FSD",
                "java",
                "navya@gmail.com"
        );
        return emprepo.updateById(200l, emp);
    }
}