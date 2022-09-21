package com.technoidentity.resource.controller;

import com.technoidentity.resource.model.Employee;
import com.technoidentity.resource.service.EmployeeService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
