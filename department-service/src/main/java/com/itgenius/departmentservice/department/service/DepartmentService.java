package com.itgenius.departmentservice.department.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itgenius.departmentservice.department.model.Department;
import com.itgenius.departmentservice.department.repository.DepartmentRepository;
import com.itgenius.departmentservice.employee.client.EmployeeClient;
import com.itgenius.departmentservice.employee.model.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    // find all departments
    public List<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }

    @HystrixCommand(fallbackMethod = "findDepartmentByIdRecovery")
    // find department by id
    public Department findDepartmentById(int id) {

        Optional<Department> department = departmentRepository.findById(id);
        
        department.ifPresent(d -> {
            List<Employee> employees = employeeClient.findEmployeeByDepartmentId(d.getId());
            d.setOrganizationId(employees.get(0).getOrganizationId());
        });

        return department.orElse(null);
    }

    // find department by id recovery
    public Department findDepartmentByIdRecovery(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    // add new department
    public Department addNewDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // update department
    public Department updateDepartment(Integer id, Department updatDepartment) {
        if(departmentRepository.existsById(id)) {
            updatDepartment.setId(id);
            return departmentRepository.save(updatDepartment);
        } else {
            throw new RuntimeException("Department not found for id: " + id);
        }
    }

    // delete department
    public void deleteDepartment(Integer id) {
        if(departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Department not found for id: " + id);
        }
    }

    // find department by organization id
    public List<Department> findDepartmentByOrganizationId(Integer organizationId) {
        return departmentRepository.findByOrganizationId(organizationId);
    }

}
