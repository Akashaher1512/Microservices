package com.akash.employeeservice.controller;

import com.akash.employeeservice.dto.ApiResponseDto;
import com.akash.employeeservice.dto.EmployeeDto;
import com.akash.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    // save employee rest api
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(employee , HttpStatus.CREATED);
    }

    // get employee by id
    @GetMapping("/{employeeId}")
    public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable Long employeeId){
        ApiResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);

        return new ResponseEntity<>(apiResponseDto , HttpStatus.OK);
    }
}
