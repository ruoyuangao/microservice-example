package com.example.employee.service;

import com.example.employee.domain.EmployeeInfo;
import com.example.employee.domain.EmployeeRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface EmployeeService {
    EmployeeRequestDTO getAllEmployees();

    Map<String, List<EmployeeInfo>>  employeesFilerByID(String id);
}
