package com.example.search.service.impl;

import com.example.employee.domain.EmployeeRequestDTO;
import com.example.search.domain.SearchDetail;
import com.example.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchServiceImpl implements SearchService {

    private final RestTemplate restTemplate;

    @Autowired
    public SearchServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public SearchDetail getAllInfo() {
        SearchDetail searchDetail = new SearchDetail();
        EmployeeRequestDTO employeeRequestDTO = restTemplate.getForObject("http://employee/employees",EmployeeRequestDTO.class);
        searchDetail.setEmployeeInfo(employeeRequestDTO.getEmployeeInfoList());
//        searchDetail.setStudentInfo(restTemplate.getForObject("http://university/students", List.class));
//        searchDetail.setProfessorInfo(restTemplate.getForObject("http://university/professors", List.class));

        return searchDetail;
    }

}
