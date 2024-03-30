package com.donsitechitacad.employee_crud_project.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.donsitechitacad.employee_crud_project.model.Employee;
import com.donsitechitacad.employee_crud_project.services.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // POST "/" new employee
    @PostMapping("")
    public ResponseEntity<Employee> postEmployee(
            @RequestBody Employee employee) {

        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<Employee>(
                savedEmployee, HttpStatus.CREATED);
    }

    // GET "/" all employees
    @GetMapping("")
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees;
    }

    // GET "/:id" an employee with given id
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(
            @PathVariable("id") long id) {

        return new ResponseEntity<Employee>(
                employeeService.getEmployee(id), HttpStatus.OK);
    }

    // PATCH "/:id" update employee with given id
    @PatchMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable("id") long id,
            @RequestBody Employee employee) {

        return new ResponseEntity<Employee>(
                employeeService.updateEmployee(id, employee), HttpStatus.OK);
    }

    // DELETE "/:id" delete employee with given id
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(
            @PathVariable("id") long id) {

        return new ResponseEntity<Employee>(
                employeeService.deleteEmployee(id), HttpStatus.OK);
    }
}
