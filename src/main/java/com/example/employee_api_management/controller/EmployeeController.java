package com.example.employee_api_management.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_api_management.entity.Employee;
import com.example.employee_api_management.service.EmpService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class EmployeeController {
    
    @Autowired
    EmpService empService;

    @PostMapping("/")   
    public void add(){
        empService.addEmployee();
    }

    @GetMapping("/findall")
    public ArrayList<Employee> findAllEmployees(){
        return empService.findAllEmployee();
    }


    @GetMapping("/findbyid/{id}")   
    public Employee findEmployeeById(@PathVariable long id){
        return empService.findEmployeeById(id);
    }

    @DeleteMapping("/delete")
    public void deleteAllEmployee(){
        empService.deleteAllEmployee();
    }


}
