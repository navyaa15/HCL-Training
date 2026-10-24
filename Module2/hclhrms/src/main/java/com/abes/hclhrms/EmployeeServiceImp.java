package com.abes.hclhrms;

import com.abes.hclhrms.entity.Employee;
import com.abes.hclhrms.repository.EmpRepo;
import com.abes.hclhrms.repository.EmpRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp {

    @Autowired
    private EmpRepo emprepo;

    public String addEmp(){
        Employee emp1 = new Employee(200l, "Abhay", "FSD", "Java","abhay123@gmail.com");
        return emprepo.addemp(emp1);
    }
    public List<Employee> getEmp(){
        return emprepo.getEmp();
    }
    public Employee getEmpId(){
        return emprepo.getEmpById(200l);
    }
    public String addEmpBulk(){
        return emprepo.addEmpbulk();
    }

    public String deleteById(){
        long emp_id=200l;
        return emprepo.deleteById(emp_id);
    }
}