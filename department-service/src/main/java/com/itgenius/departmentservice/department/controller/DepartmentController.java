package com.itgenius.departmentservice.department.controller;
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
import com.itgenius.departmentservice.department.model.Department;
import com.itgenius.departmentservice.department.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    // logger
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DepartmentService departmentService;

    // find all departments
    @GetMapping
    public List<Department> findAllDepartment() {
        logger.info("DEPARTMENT WAS CALLED");
        return departmentService.findAllDepartment();
    }

    // find department by id
    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable Integer id) {
        return departmentService.findDepartmentById(id);
    }

    // add new department
    @PostMapping
    public Department addNewDepartment(Department department) {
        return departmentService.addNewDepartment(department);
    }

    // update department
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(
        @PathVariable Integer id, 
        @RequestBody Department department) {
            Department updateDepartment = departmentService.updateDepartment(id, department);
            return new ResponseEntity<>(updateDepartment, HttpStatus.OK);
    }

    // delete department
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // find department by organization id
    @GetMapping("/organization/{organizationId}")
    public List<Department> findDepartmentByOrganizationId(@PathVariable Integer organizationId) {
        return departmentService.findDepartmentByOrganizationId(organizationId);
    }

}
