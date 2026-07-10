package com.example.employee_api_management.controller;

import com.example.employee_api_management.dto.EmployeeRequestDTO;
import com.example.employee_api_management.dto.EmployeeResponseDTO;
import com.example.employee_api_management.service.EmpService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmpService empService;

    // CREATE EMPLOYEE
    @PostMapping
    public EmployeeResponseDTO addEmployee(
            @Valid @RequestBody EmployeeRequestDTO dto) {

        return empService.addEmployee(dto);
    }

    // GET ALL EMPLOYEES
    @GetMapping
    // public List<EmployeeResponseDTO> findAllEmployees() {
    //     return empService.findAllEmployees();
    // }
    public Page<EmployeeResponseDTO> findAllEmployees(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {
        
            return empService.findAllEmployees(page, size);
    }

    // GET EMPLOYEE BY ID
    @GetMapping("/{id}")
    public EmployeeResponseDTO findEmployeeById(@PathVariable long id) {
        return empService.findEmployeeById(id);
    }

    // Search employees
    @GetMapping("/search")
    public List<EmployeeResponseDTO> searchEmployees(
        @RequestParam String name) {

    return empService.searchEmployees(name);
}

    // DELETE ALL EMPLOYEES
    @DeleteMapping
    public void deleteAllEmployees() {
        empService.deleteAllEmployees();
    }
}