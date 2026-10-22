package com.abes.hclhrms;


import com.abes.hclhrms.entity.Employee;
import com.abes.hclhrms.reppository.EmpRepoImp;
import com.abes.hclhrms.reppository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp {
    @Autowired
    private EmpRepoImp empRepoImp;

    public String addEmp(){
        Employee emp = new Employee(101, "John Doe", "FSD", "Java", "john.doe@example.com");
        return empRepoImp.addemp(emp);
    }

    public List<Employee> getEmp(){
        List<Employee> empList = empRepoImp.getEmp();
        return empList;
    }
}