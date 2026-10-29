package com.abes.hrmsdatabase.service;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public String createnewEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "New Employee Created Successfully";
    }


    public Employee registerEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(long emp_id) {
        return employeeRepository.findById(emp_id).orElse(null);
    }

    public String deleteById(long emp_id) {
        if (employeeRepository.existsById(emp_id)) {
            employeeRepository.deleteById(emp_id);
            return "Employee deleted";
        }

        return "Employee not found";
    }

    public String updateById(long emp_id, Employee updatedEmployee) {
        Employee emp = employeeRepository.findById(emp_id).orElse(null);

        if (emp != null) {
            emp.setEmp_name(updatedEmployee.getEmp_name());
            emp.setDesignation(updatedEmployee.getDesignation());
            emp.setStack(updatedEmployee.getStack());
            emp.setEmail(updatedEmployee.getEmail());
            emp.setPassword(updatedEmployee.getPassword());

            employeeRepository.save(emp);
            return "Employee updated";
        }

        return "Employee not found";
    }

    public String verification(long empId, String password) {
        Employee employee = employeeRepository.findById(empId).orElse(null);
        if (employee != null && password.equals(employee.getPassword())) {
            return "Login successful";
        }
        return "Invalid employee ID or password";
    }
}