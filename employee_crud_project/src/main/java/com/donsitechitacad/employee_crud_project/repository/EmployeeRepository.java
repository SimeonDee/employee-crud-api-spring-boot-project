package com.donsitechitacad.employee_crud_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donsitechitacad.employee_crud_project.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
