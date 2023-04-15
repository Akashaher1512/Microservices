package com.akash.employeeservice.service;

import com.akash.employeeservice.dto.ApiResponseDto;
import com.akash.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    ApiResponseDto getEmployeeById(long employeeId);
}
