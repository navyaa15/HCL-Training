package com.abes.hclhrms.repository;

import com.abes.hclhrms.entity.Employee;
import java.util.List;

public interface EmpRepo {
    String addemp(Employee emp);
    List<Employee> getEmp();
    String addEmpbulk();
    Employee getEmpById(long empid);
    String deleteById(long empid);
    String updateById(long empid,Employee updatedEmp);
}