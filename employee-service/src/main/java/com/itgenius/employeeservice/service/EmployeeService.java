package com.itgenius.employeeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itgenius.employeeservice.model.Employee;
import com.itgenius.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // find all employees
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    // find employee by id
    public Employee findEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // add new employee
    public Employee addNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // update employee
    public Employee updateEmployee(Integer id, Employee updatEmployee) {
        if(employeeRepository.existsById(id)) {
            updatEmployee.setId(id);
            return employeeRepository.save(updatEmployee);
        } else {
            throw new RuntimeException("Employee not found for id: " + id);
        }
    }

    // delete employee
    public void deleteEmployee(Integer id) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Employee not found for id: " + id);
        }
    }

    // find employee by department id
    public List<Employee> findEmployeeByDepartmentId(Integer departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    // find employee by organization id
    public List<Employee> findEmployeeByOrganizationId(Integer organizationId) {
        return employeeRepository.findByOrganizationId(organizationId);
    }
}
