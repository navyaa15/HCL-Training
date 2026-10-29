package com.abes.hrmsdatabase.service;

import com.abes.hrmsdatabase.model.Attendance;
import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.repository.AttendanceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class AttendenceService {
    private static final ZoneId ZONE = ZoneId.of("Asia/Kolkata");
    private final AttendanceRepository attendance;
    private final EmployeeService employees;
    public AttendenceService(AttendanceRepository attendance, EmployeeService employees) {
        this.attendance = attendance; this.employees = employees;
    }
    public record AttendanceView(long attendanceId, LocalDate attendanceDate, LocalDateTime inTime, LocalDateTime outTime) {
        public static AttendanceView of(Attendance a) { return new AttendanceView(a.getAttendanceId(), a.getAttendanceDate(), a.getInTime(), a.getOutTime()); }
    }
    public List<AttendanceView> history(long id) {
        Employee e = employees.find(id);
        return attendance.findByEmployeeOrderByAttendanceDateDesc(e).stream().map(AttendanceView::of).toList();
    }
    @Transactional
    public AttendanceView checkIn(long id) {
        Employee e = employees.find(id);
        LocalDateTime now = LocalDateTime.now(ZONE);
        if (attendance.findByEmployeeAndAttendanceDate(e, now.toLocalDate()).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Attendance already marked today");
        Attendance record = new Attendance();
        record.setEmployee(e);
        record.setAttendanceDate(now.toLocalDate());
        record.setInTime(now);
        return AttendanceView.of(attendance.save(record));
    }
    @Transactional
    public AttendanceView checkOut(long id) {
        Employee e = employees.find(id);
        LocalDateTime now = LocalDateTime.now(ZONE);
        Attendance record = attendance.findByEmployeeAndAttendanceDate(e, now.toLocalDate())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Check in first"));
        if (record.getOutTime() != null)
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Already checked out today");
        record.setOutTime(now);
        return AttendanceView.of(attendance.save(record));
    }
}
