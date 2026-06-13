package com.example.employee_api_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee_api_management.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    // ArrayList<Employee>findAllEmployee();
    boolean existsByEmail(String email);
}
