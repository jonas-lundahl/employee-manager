package com.example.employeemanager.service;

import com.example.employeemanager.exception.UserNotFoundException;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service // class is a service which will be responsible for updating the rows in the database
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired // Tell Spring to perform dependency injection
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    /**
     * Adds a new employee to the database. A random employee code is generated for the employee
     *
     * @param employee the employee to add
     * @return the added employee
     */
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    /**
     * Returns a list of all employees in the database.
     *
     * @return a list of all employees in the database
     */
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    /**
     * Updates the given employee in the database.
     *
     * @param employee the employee to update
     * @return the updated employee
     */
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    /**
     * Finds the employee with the given id in the database and returns it.
     *
     * @param id the id of the employee to find
     * @return the found employee
     * @throws UserNotFoundException if the user was not found
     */
    public Employee findEmployeeById(Long id) {
        return employeeRepo
                .findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " was not found."));
    }

    /**
     * Deletes the employee with the given id from the database.
     *
     * @param id the id of the employee to delete
     */
    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }
}
