package com.abes.hrmsdatabase.repository;

import com.abes.hrmsdatabase.model.Attendance;
import com.abes.hrmsdatabase.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AttendanceRepository
        extends JpaRepository<Attendance, Long> {

    boolean existsByEmployeeAndAttendanceDate(
            Employee employee, LocalDate attendanceDate);
}