package com.abes.hrmsdatabase.service;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String createnewEmployee(){
        Employee emp1 = new Employee(200l, "John Doe", "Java", "Software Engineer");
        employeeRepository.save(emp1);
        return "New Employee Created";
    }

    public Employee getEmployeeById(long emp_id) {
        return employeeRepository.findById(emp_id).orElse(null);
    }

    public String deleteById(long emp_id) {
        if(employeeRepository.existsById(emp_id)){
            employeeRepository.deleteById(emp_id);
            return "Employee deleted";
        }
        return "Employee not found";
    }

    public String updateById(long emp_id) {
        Employee emp = employeeRepository.findById(emp_id).orElse(null);
        if(emp != null){
            Employee updatedEmp = new Employee(
                    emp_id,"Lakshit","Java FSD", "Developer"
            );
            employeeRepository.save(updatedEmp);
            return "Employee updated";
        }
        return "Employee not found";
    }
}