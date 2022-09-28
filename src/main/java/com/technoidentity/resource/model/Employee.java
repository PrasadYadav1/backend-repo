package com.technoidentity.resource.model;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "dateOfJoining")
  private LocalDate dateOfJoining;

  @Column(name = "designation")
  private String designation;

  @Column(name = "project")
  private String project;

  @Column(name = "reportingManager")
  private String reportingManager;

  @Column(name = "experience")
  private int experience;

  @Column(name = "salary")
  private int salary;

  @Column(name = "billing")
  private int billing;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getDateOfJoining() {
    return dateOfJoining;
  }

  public void setDateOfJoining(LocalDate dateOfJoining) {
    this.dateOfJoining = dateOfJoining;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getProject() {
    return project;
  }

  public void setProject(String project) {
    this.project = project;
  }

  public String getReportingManager() {
    return reportingManager;
  }

  public void setReportingManager(String reportingManager) {
    this.reportingManager = reportingManager;
  }

  public int getExperience() {
    return experience;
  }

  public void setExperience(int experience) {
    this.experience = experience;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public int getBilling() {
    return billing;
  }

  public void setBilling(int billing) {
    this.billing = billing;
  }
}
