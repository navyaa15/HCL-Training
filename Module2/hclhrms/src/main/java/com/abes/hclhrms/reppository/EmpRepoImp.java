package com.abes.hclhrms.reppository;

import com.abes.hclhrms.entity.Employee;
import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class EmpRepoImp implements EmployeeRepo {

    List<Employee> emplist = new ArrayList<>();
    @Override
    public String addemp(Employee emp) {
        emplist.add(emp);
        return "Employee added successfully";
    }

    @Override
    public List <Employee> getEmp() {
        return emplist;
    }

    @Override
    public Employee getEmpById(long emp_id) {
        return null;
    }

    @Override
    public String deleteById(long emp_id) {
        return null;
    }

    @Override
    public String updateById(long emp, Employee updateEmp) {
        return "";
    }
}