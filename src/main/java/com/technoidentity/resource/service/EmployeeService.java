package com.technoidentity.resource.service;

import com.technoidentity.resource.mapping.EmployeeMapper;
import com.technoidentity.resource.model.Employee;
import com.technoidentity.resource.model.EmployeeRequest;
import com.technoidentity.resource.model.EmployeeResponse;
import com.technoidentity.resource.repository.EmployeeRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  private final EmployeeRepository employeeRepository;
  private final EmployeeMapper mapper;

  public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper mapper) {
    this.employeeRepository = employeeRepository;
    this.mapper = mapper;
  }

  public List<Employee> findEmployees() {
    return employeeRepository.findAll();
  }

  public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest) {
    Employee employee = employeeRepository.save(mapper.map(employeeRequest));

    return mapper.mapEmployee(employee);
  }
}
