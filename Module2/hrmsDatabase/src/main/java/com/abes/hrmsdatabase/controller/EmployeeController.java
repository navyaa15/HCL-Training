package com.abes.hrmsdatabase.controller;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.service.EmployeeService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String msg(){
        return "<h2>Welcome to Springboot HRMS Database Application</h2>";
    }

    @GetMapping("/create")
    public String addnewEmployee() {
        return employeeService.createnewEmployee();
    }

    @GetMapping("findbyid/{empid}")
    public Employee getEmpById(@PathVariable long empid){
        return employeeService.getEmployeeById(empid);

    }

    @DeleteMapping("delete/{empid}")
    public String deleteEmployee(@PathVariable long empid){
        return employeeService.deleteById(empid);
    }

   @PutMapping("update/{empid}")
    public String updateById(@PathVariable long empid){
        return employeeService.updateById(empid);
   }
}