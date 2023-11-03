package com.itgenius.employeeservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itgenius.employeeservice.model.Employee;
import com.itgenius.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    
    // logger
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/test")
    public String test() {
        return "this is demo microservice";
    }

    // find all employees
    @GetMapping
    public List<Employee> findAllEmployee() {
        logger.info("EMPLOYEE WAS CALLED");
        return employeeService.findAllEmployee();
    }

    // find employee by id
    @GetMapping("/{id}")
    public Employee findEmployee(@PathVariable Integer id) {
        return employeeService.findEmployeeById(id);
    }

    // add new employee
    @PostMapping
    public Employee addNewEmployee(@RequestBody Employee employee) {
        return employeeService.addNewEmployee(employee);
    }

    // update employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
        @PathVariable Integer id, 
        @RequestBody Employee employee) {
            Employee updatedEmployee = employeeService.updateEmployee(id, employee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    // delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // find employee by department id
    @GetMapping("/department/{departmentId}")
    public List<Employee> findEmployeeByDepartmentId(@PathVariable Integer departmentId) {
        logger.info("EMPLOYEE WAS CALLED");
        return employeeService.findEmployeeByDepartmentId(departmentId);
    }

    // find employee by organization id
    @GetMapping("/organization/{organizationId}")
    public List<Employee> findEmployeeByOrganizationId(@PathVariable Integer organizationId) {
        return employeeService.findEmployeeByOrganizationId(organizationId);
    }

}
