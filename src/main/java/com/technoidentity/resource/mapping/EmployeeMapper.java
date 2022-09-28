package com.technoidentity.resource.mapping;

import static java.util.Optional.ofNullable;

import com.technoidentity.resource.model.Employee;
import com.technoidentity.resource.model.EmployeeRequest;
import com.technoidentity.resource.model.EmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(config = MappingConfig.class)
@Component
public abstract class EmployeeMapper {

  @Mappings({
    @Mapping(target = "id", source = "source.id"),
    @Mapping(target = "name", source = "source.name"),
    @Mapping(target = "dateOfJoining", source = "source.dateOfJoining"),
    @Mapping(target = "designation", source = "source.designation"),
    @Mapping(target = "project", source = "source.project"),
    @Mapping(target = "reportingManager", source = "source.reportingManager"),
    @Mapping(target = "experience", source = "source.experience"),
    @Mapping(target = "salary", source = "source.salary"),
    @Mapping(target = "billing", source = "source.billing"),
  })
  public abstract EmployeeResponse mapToEmployeeResponse(Employee source);

  public EmployeeResponse mapEmployee(Employee source) {
    return ofNullable(mapToEmployeeResponse(source)).orElse(null);
  }

  @Mappings({
    @Mapping(target = "id", ignore = true),
    @Mapping(target = "name", source = "source.name"),
    @Mapping(target = "dateOfJoining", source = "source.dateOfJoining"),
    @Mapping(target = "designation", source = "source.designation"),
    @Mapping(target = "project", source = "source.project"),
    @Mapping(target = "reportingManager", source = "source.reportingManager"),
    @Mapping(target = "experience", source = "source.experience"),
    @Mapping(target = "salary", source = "source.salary"),
    @Mapping(target = "billing", source = "source.billing")
  })
  public abstract Employee mapToEmployee(EmployeeRequest source);

  public Employee map(EmployeeRequest source) {
    return ofNullable(mapToEmployee(source)).orElse(null);
  }
}
