package com.donsitechitacad.employee_crud_project.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.donsitechitacad.employee_crud_project.exception.ResourceNotFoundException;
import com.donsitechitacad.employee_crud_project.model.Employee;
import com.donsitechitacad.employee_crud_project.repository.EmployeeRepository;
import com.donsitechitacad.employee_crud_project.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(long id) {
        // Optional<Employee> employee = employeeRepository.findById(id);
        // if (employee.isPresent()) {
        // return employee.get();
        // } else {
        // throw new ResourceNotFoundException("Employee", "id", id);
        // }

        // Best practice
        return employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", id));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        // locate employee with given id
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", id));

        // update fields
        if (employee.getFirstName() != null && !employee.getFirstName().isBlank())
            existingEmployee.setFirstName(employee.getFirstName());

        if (employee.getLastName() != null && !employee.getLastName().isBlank())
            existingEmployee.setLastName(employee.getLastName());

        if (employee.getEmail() != null && !employee.getEmail().isBlank())
            existingEmployee.setEmail(employee.getEmail());

        if (employee.getFirstName() != null && employee.getAge() > 0)
            existingEmployee.setAge(employee.getAge());

        // save updates
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public Employee deleteEmployee(long id) {
        if (employeeRepository.existsById(id)) {
            Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException("Employee", "id", id));

            employeeRepository.delete(existingEmployee);
            return existingEmployee;

        } else {
            throw new ResourceNotFoundException("Employee", "id", id);
        }
    }
}
