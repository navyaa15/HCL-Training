package com.abes.hrmsdatabase.service;

import com.abes.hrmsdatabase.model.Attendance;
import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.repository.AttendanceRepository;
import com.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendenceService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    public String markAttendance(Attendance attendance) {

        if (attendance.getEmployee() == null) {
            return "Employee is required";
        }

        if (attendance.getAttendanceDate() == null) {
            return "Attendance date is required";
        }

        long empId = attendance.getEmployee().getEmp_id();

        Employee employee = employeeRepository.findById(empId)
                .orElse(null);

        if (employee == null) {
            return "Employee not found";
        }

        if (attendanceRepository.existsByEmployeeAndAttendanceDate(
                employee, attendance.getAttendanceDate())) {
            return "Attendance already marked for this date";
        }

        attendance.setEmployee(employee);
        attendanceRepository.save(attendance);

        return "Attendance marked successfully";
    }
}