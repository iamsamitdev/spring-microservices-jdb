package com.itgenius.departmentservice.employee.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import com.itgenius.departmentservice.employee.model.Employee;

@FeignClient(
    name = "employee-service", 
    url = "http://localhost:8081/employees"
)
public interface EmployeeClient {
    @GetMapping("/department/{departmentId}")
    List<Employee> findEmployeeByDepartmentId(@PathVariable int departmentId);
}
