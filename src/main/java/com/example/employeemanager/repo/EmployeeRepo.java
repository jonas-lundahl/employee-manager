package com.example.employeemanager.repo;

import com.example.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository needs to know the class and its primary key type
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    // By using this naming convention, Spring understands what it is we are trying to do
    void deleteEmployeeById(Long id);

    // This is called a query method in Spring
    Optional<Employee> findEmployeeById(Long id);
}
