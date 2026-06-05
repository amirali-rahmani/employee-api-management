package com.example.employee_api_management.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_api_management.entity.Employee;
import com.example.employee_api_management.repository.EmployeeRepository;

@Service
public class EmpService {
    
    @Autowired
    EmployeeRepository employeeRepository;

    public ArrayList<Employee> findAllEmployee(){
           return (ArrayList<Employee>) employeeRepository.findAll();
    }

    public Employee findEmployeeById(long id){
            Optional<Employee> employee = employeeRepository.findById(id);
            if(employee.isPresent())
                 return employee.get();
            else
                return null;    

    }

    public void addEmployee(){
         ArrayList<Employee> employees = new ArrayList<Employee>();

         employees.add(new Employee("Amirali","Rahmani","C++ developer",
         "Rahmani-A@behpardakht.com",new BigDecimal("50000000"),LocalDate.of(2025,4,1)));

         employees.add(new Employee("Shadan","Rahmani","Java developer",
         "Rahmani-S@TIDDEV.com",new BigDecimal("60000000"),LocalDate.of(2024,5,1)));

         employees.add(new Employee("Jack","Smith","C# developer",
         "Smith-@apple.com",new BigDecimal("100000000"),LocalDate.of(2020,6,1)));

         employees.add(new Employee("Roberto","Carlos","python developer",
         "Carlos-S@google.com",new BigDecimal("110000000"),LocalDate.of(2021,5,1)));

         employeeRepository.saveAll(employees);
    }

    public void deleteAllEmployee(){
         employeeRepository.deleteAll();
    }

}
