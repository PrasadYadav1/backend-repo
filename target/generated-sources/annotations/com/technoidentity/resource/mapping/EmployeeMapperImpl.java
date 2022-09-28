package com.technoidentity.resource.mapping;

import com.technoidentity.resource.model.Employee;

import com.technoidentity.resource.model.EmployeeRequest;

import com.technoidentity.resource.model.EmployeeResponse;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2022-09-28T12:23:58+0530",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 11.0.10 (JetBrains s.r.o.)"

)

@Component

public class EmployeeMapperImpl extends EmployeeMapper {

    @Override

    public EmployeeResponse mapToEmployeeResponse(Employee source) {

        if ( source == null ) {

            return null;
        }

        EmployeeResponse employeeResponse = new EmployeeResponse();

        employeeResponse.setDateOfJoining( source.getDateOfJoining() );

        employeeResponse.setReportingManager( source.getReportingManager() );

        employeeResponse.setName( source.getName() );

        employeeResponse.setProject( source.getProject() );

        if ( source.getId() != null ) {

            employeeResponse.setId( source.getId().intValue() );
        }

        employeeResponse.setDesignation( source.getDesignation() );

        employeeResponse.setExperience( source.getExperience() );

        employeeResponse.setSalary( source.getSalary() );

        employeeResponse.setBilling( source.getBilling() );

        return employeeResponse;
    }

    @Override

    public Employee mapToEmployee(EmployeeRequest source) {

        if ( source == null ) {

            return null;
        }

        Employee employee = new Employee();

        employee.setDateOfJoining( source.getDateOfJoining() );

        employee.setReportingManager( source.getReportingManager() );

        employee.setName( source.getName() );

        employee.setProject( source.getProject() );

        employee.setDesignation( source.getDesignation() );

        employee.setExperience( source.getExperience() );

        employee.setSalary( source.getSalary() );

        employee.setBilling( source.getBilling() );

        return employee;
    }
}

