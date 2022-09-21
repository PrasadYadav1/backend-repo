package com.technoidentity.resource.service;

import com.technoidentity.resource.model.Employee;
import com.technoidentity.resource.repository.EmployeeRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  public List<Employee> findEmployees() {
    return employeeRepository.findAll();
  }
}
