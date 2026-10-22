
package com.abes.hclhrms.reppository;

import com.abes.hclhrms.entity.Employee;
import java.util.List;

public interface EmployeeRepo {

    String addemp(Employee emp);

    List<Employee> getEmp();

    Employee getEmpById(long empid);

    String deleteById(long empid);

    String updateById(long empid, Employee updateEmp);
}

