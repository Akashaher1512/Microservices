package com.akash.departmentservice.repository;

import com.akash.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department , Long> {
    Department findByDepartmentCode(String code);

}
