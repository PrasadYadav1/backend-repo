package com.technoidentity.resource.controller;

import com.technoidentity.resource.model.Employee;
import com.technoidentity.resource.model.EmployeeRequest;
import com.technoidentity.resource.model.EmployeeResponse;
import com.technoidentity.resource.service.EmployeeService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/showEmployees")
  @ResponseBody
  public List<Employee> findEmployees() {

    return employeeService.findEmployees();
  }

  @PostMapping("/create")
  public EmployeeResponse createEmployee(@RequestBody EmployeeRequest employee) {
    return employeeService.saveEmployee(employee);
  }
}
