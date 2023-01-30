package com.example.search.service;

import com.example.employee.domain.EmployeeRequestDTO;
import com.example.search.domain.SearchDetail;
import com.example.university.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchService {

    List<SearchDetail> getAllInfo();
}
