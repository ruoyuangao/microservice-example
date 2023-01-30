package com.example.search.domain;

import com.example.employee.domain.EmployeeInfo;
import com.example.university.entity.Professor;
import com.example.university.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class SearchDetail {

    private List<EmployeeInfo> employeeInfo;

    private List<Student> studentInfo;

    private List<Professor> professorInfo;
}
