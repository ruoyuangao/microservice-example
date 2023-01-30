package com.example.employee.service.impl;

import com.example.employee.domain.EmployeeInfo;
import com.example.employee.domain.EmployeeRequestDTO;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final RestTemplate restTemplate;

    @Value("${user.rest.url}")
    private String url;

    @Autowired
    public EmployeeServiceImpl (RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public EmployeeRequestDTO getAllEmployees() {
        EmployeeRequestDTO employeeRequestDTO = restTemplate.getForObject(url, EmployeeRequestDTO.class);
        return employeeRequestDTO;
    }

    @Override
    public Map<String, List<EmployeeInfo>> employeesFilerByID(String id) {
        EmployeeRequestDTO employeeRequestDTO = restTemplate.getForObject(url, EmployeeRequestDTO.class);
        List<EmployeeInfo> employeeInfoList = employeeRequestDTO
                .getEmployeeInfoList()
                .stream()
                .filter(u -> Long.valueOf(u.getId()) >= Long.valueOf(id))
                .collect(Collectors.toList());
        Map<String, List<EmployeeInfo>> res = new HashMap<>();
        res.put("result", employeeInfoList);
        return res;
    }
}
