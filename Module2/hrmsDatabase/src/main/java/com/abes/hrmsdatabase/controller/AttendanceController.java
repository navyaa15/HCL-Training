package com.abes.hrmsdatabase.controller;

import com.abes.hrmsdatabase.model.Attendance;
import com.abes.hrmsdatabase.service.AttendenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user/attendance")
public class AttendanceController {

    @Autowired
    private AttendenceService attendenceService;

    @PostMapping("/mark")
    public String markAttendance(@RequestBody Attendance attendance) {
        return attendenceService.markAttendance(attendance);
    }
}