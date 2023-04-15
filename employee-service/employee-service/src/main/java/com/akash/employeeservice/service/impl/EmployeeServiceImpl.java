package com.akash.employeeservice.service.impl;

import com.akash.employeeservice.dto.ApiResponseDto;
import com.akash.employeeservice.dto.DepartmentDto;
import com.akash.employeeservice.dto.EmployeeDto;
import com.akash.employeeservice.entity.Employee;
import com.akash.employeeservice.repository.EmployeeRepository;
import com.akash.employeeservice.service.APIClient;
import com.akash.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    //private RestTemplate restTemplate;

   //private WebClient webClient;

    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee(
          employeeDto.getId(),
          employeeDto.getFirstName(),
          employeeDto.getLastName(),
          employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = new EmployeeDto(
            savedEmployee.getId(),
            savedEmployee.getFirstName(),
            savedEmployee.getLastName(),
            savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );

        return savedEmployeeDto;
    }

    @Override
    public ApiResponseDto getEmployeeById(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

/*        //by using RestTemplate
        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8082/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);

       DepartmentDto departmentDto = responseEntity.getBody();*/

/*
        // by using WebClient
        DepartmentDto departmentDto = webClient.get().uri("http://localhost:8082/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
*/

        // by using openFeign
        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());


        EmployeeDto employeeDto = new EmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail(),
                employee.getDepartmentCode()
        );

        ApiResponseDto apiResponseDto = new ApiResponseDto(
          employeeDto,
          departmentDto
        );

        return apiResponseDto;
    }

}
