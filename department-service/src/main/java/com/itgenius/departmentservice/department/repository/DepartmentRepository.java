package com.itgenius.departmentservice.department.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.itgenius.departmentservice.department.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findByOrganizationId(int organizationId);
}
