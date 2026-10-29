package com.abes.hrmsdatabase.service;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;
    public EmployeeService(EmployeeRepository repository) { this.repository = repository; }

    public Employee register(Employee input) {
        if (input.getEmp_id() <= 0 || blank(input.getEmp_name()) || blank(input.getEmail()) || blank(input.getPassword()) || input.getPassword().length() < 8)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee ID, name, email and password (at least 8 characters) are required");
        if (repository.existsById(input.getEmp_id()) || repository.existsByEmailIgnoreCase(input.getEmail().trim()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Employee ID or email already registered");
        input.setEmail(input.getEmail().trim().toLowerCase());
        input.setEmp_name(input.getEmp_name().trim());
        input.setPassword(hash(input.getPassword()));
        return repository.save(input);
    }

    public Employee login(long id, String password) {
        Employee employee = repository.findById(id).orElse(null);
        if (employee == null || blank(password) || !matches(password, employee.getPassword()))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid employee ID or password");
        // Upgrade passwords saved by the older version after a successful login.
        if (!employee.getPassword().startsWith("pbkdf2:")) {
            employee.setPassword(hash(password));
            repository.save(employee);
        }
        return employee;
    }

    public Employee find(long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Session expired"));
    }

    private static boolean blank(String s) { return s == null || s.isBlank(); }
    private static String hash(String password) {
        try {
            byte[] salt = new byte[16];
            new SecureRandom().nextBytes(salt);
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 120000, 256);
            byte[] key = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();
            spec.clearPassword();
            return "pbkdf2:" + Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(key);
        } catch (Exception e) { throw new IllegalStateException("Password hashing failed", e); }
    }
    private static boolean matches(String password, String stored) {
        if (stored == null) return false;
        if (!stored.startsWith("pbkdf2:")) return MessageDigest.isEqual(password.getBytes(java.nio.charset.StandardCharsets.UTF_8), stored.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        try {
            String[] parts = stored.split(":");
            byte[] salt = Base64.getDecoder().decode(parts[1]);
            byte[] expected = Base64.getDecoder().decode(parts[2]);
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 120000, 256);
            byte[] actual = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();
            spec.clearPassword();
            return MessageDigest.isEqual(expected, actual);
        } catch (Exception e) { return false; }
    }
}
