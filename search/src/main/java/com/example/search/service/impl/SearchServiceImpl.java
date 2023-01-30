package com.example.search.service.impl;

import com.example.employee.domain.EmployeeInfo;
import com.example.employee.domain.EmployeeRequestDTO;
import com.example.search.domain.SearchDetail;
import com.example.search.service.SearchService;
import com.example.university.entity.Professor;
import com.example.university.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Service
public class SearchServiceImpl implements SearchService {

    private final RestTemplate restTemplate;

    @Autowired
    public SearchServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public List<SearchDetail> getAllInfo() {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        CompletableFuture<SearchDetail> completableEmployeeInfoFuture = CompletableFuture.supplyAsync(
                () -> {
                    EmployeeRequestDTO employeeRequestDTO = restTemplate.getForObject("http://employee/employees",EmployeeRequestDTO.class);
                    if (employeeRequestDTO == null) {
                        return null;
                    }
                    List<EmployeeInfo> employeeInfoList = employeeRequestDTO.getEmployeeInfoList();
                    Map<String, Object> map = new HashMap<>();
                    map.put("EmployeeInfoDetail", employeeInfoList);
                    SearchDetail searchDetail = new SearchDetail();
                    searchDetail.setSearchDetail(map);
                    return searchDetail;
                }, executor
        );

        CompletableFuture<SearchDetail> completableStudentInfoFuture = CompletableFuture.supplyAsync(
                () -> {
                    List<Student> studentList = restTemplate.getForObject("http://university/students", List.class);
                    if (studentList == null) {
                        return null;
                    }
                    Map<String, Object> map = new HashMap<>();
                    map.put("StudentInfoDetail", studentList);
                    SearchDetail searchDetail = new SearchDetail();
                    searchDetail.setSearchDetail(map);
                    return searchDetail;
                }, executor
        );

        CompletableFuture<SearchDetail> completableProfessorInfoFuture = CompletableFuture.supplyAsync(
                () -> {
                    List<Professor> professorList = restTemplate.getForObject("http://university/professors", List.class);
                    if (professorList == null) {
                        return null;
                    }
                    Map<String, Object> map = new HashMap<>();
                    map.put("ProfessorInfoDetail", professorList);
                    SearchDetail searchDetail = new SearchDetail();
                    searchDetail.setSearchDetail(map);
                    return searchDetail;
                }, executor
        );

        List<SearchDetail> searchDetailList = new ArrayList<>();
        searchDetailList.add(completableEmployeeInfoFuture.join());
        searchDetailList.add(completableStudentInfoFuture.join());
        searchDetailList.add(completableProfessorInfoFuture.join());

        return searchDetailList;
    }

}
