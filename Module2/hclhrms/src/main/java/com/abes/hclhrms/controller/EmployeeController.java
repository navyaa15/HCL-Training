
package com.abes.hclhrms.controller;

import com.abes.hclhrms.EmployeeServiceImp;
import com.abes.hclhrms.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImp employeeServiceImp;

    @GetMapping("/welcome")
    public String welcomeMsg() {
        return "Welcome to ABES HRMS";
    }

    @GetMapping("/addemp")
    public String addnewEmployee() {
        return employeeServiceImp.addEmp();
    }

    @GetMapping("/getemp")
    public List<Employee> getemp(){
        return employeeServiceImp.getEmp();
    }
}
