package com.abes.hrmsdatabase.controller;

import com.abes.hrmsdatabase.service.AttendenceService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/user/attendance")
public class AttendanceController {
    private final AttendenceService attendance;
    public AttendanceController(AttendenceService attendance) { this.attendance = attendance; }
    @GetMapping
    public List<AttendenceService.AttendanceView> history(HttpServletRequest request) {
        return attendance.history(EmployeeController.currentId(request));
    }
    @PostMapping("/mark")
    public AttendenceService.AttendanceView mark(HttpServletRequest request) {
        return attendance.checkIn(EmployeeController.currentId(request));
    }
    @PostMapping("/checkout")
    public AttendenceService.AttendanceView checkout(HttpServletRequest request) {
        return attendance.checkOut(EmployeeController.currentId(request));
    }
}
