package com.donsitechitacad.employee_crud_project.services;

import com.donsitechitacad.employee_crud_project.model.Employee;
import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    Employee getEmployee(long id);

    List<Employee> getAllEmployees();

    Employee updateEmployee(long id, Employee employee);

    Employee deleteEmployee(long id);
}
