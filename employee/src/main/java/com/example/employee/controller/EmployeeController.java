package com.example.employee.controller;

import com.example.employee.domain.EmployeeInfo;
import com.example.employee.domain.EmployeeRequestDTO;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<EmployeeRequestDTO> getAllEmployees() {
        return new ResponseEntity<>(this.service.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<Map<String, List<EmployeeInfo>>> getEmployeesIdLargerThan(String id) {
        return new ResponseEntity<>(this.service.employeesFilerByID(id), HttpStatus.OK);
    }
}
