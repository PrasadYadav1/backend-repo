package com.technoidentity.resource.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public class EmployeeRequest {

  private String name;

  private LocalDate dateOfJoining;

  private String designation;

  private String project;

  private String reportingManager;

  private int experience;

  private int salary;

  private int billing;
}
