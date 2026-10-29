package com.abes.hrmsdatabase.controller;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v1/user")
public class EmployeeController {
    private final EmployeeService employees;
    public EmployeeController(EmployeeService employees) { this.employees = employees; }
    public record LoginRequest(long emp_id, String password) {}
    public record EmployeeView(long emp_id, String emp_name, String designation, String stack, String email) {
        public static EmployeeView of(Employee e) { return new EmployeeView(e.getEmp_id(), e.getEmp_name(), e.getDesignation(), e.getStack(), e.getEmail()); }
    }

    @PostMapping("/register")
    public EmployeeView register(@RequestBody Employee input, HttpServletRequest request) {
        Employee employee = employees.register(input);
        request.getSession();
        request.changeSessionId();
        request.getSession().setAttribute("employeeId", employee.getEmp_id());
        return EmployeeView.of(employee);
    }
    @PostMapping("/login")
    public EmployeeView login(@RequestBody LoginRequest input, HttpServletRequest request) {
        Employee employee = employees.login(input.emp_id(), input.password());
        request.getSession();
        request.changeSessionId();
        request.getSession().setAttribute("employeeId", employee.getEmp_id());
        return EmployeeView.of(employee);
    }
    @GetMapping("/me")
    public EmployeeView me(HttpServletRequest request) { return EmployeeView.of(employees.find(currentId(request))); }
    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) session.invalidate();
    }
    public static long currentId(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || !(session.getAttribute("employeeId") instanceof Long id))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Please sign in");
        return id;
    }
}
