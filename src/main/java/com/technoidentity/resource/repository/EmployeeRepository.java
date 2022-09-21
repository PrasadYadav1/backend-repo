package com.technoidentity.resource.repository;

import com.technoidentity.resource.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
