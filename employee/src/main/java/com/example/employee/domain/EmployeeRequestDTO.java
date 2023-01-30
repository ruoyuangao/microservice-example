package com.example.employee.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeRequestDTO {
    @JsonProperty("data")
    private List<EmployeeInfo> employeeInfoList;
}
