package com.example.employee_api_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_api_management.dto.DepartmentRequestDTO;
import com.example.employee_api_management.dto.DepartmentResponseDTO;
import com.example.employee_api_management.service.DepartmentService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/department")
public class DepartmentController {
    
    @Autowired
    DepartmentService departmentService;

    @PostMapping
    public DepartmentResponseDTO addDepartment(@Valid @RequestBody DepartmentRequestDTO dto){
       return departmentService.addDepartment(dto);
    }
    
    @GetMapping
    public List<DepartmentResponseDTO> findAllDepartment(){
       return departmentService.findAllDepartment();
    }

    @GetMapping("/{id}")
    public DepartmentResponseDTO findDepartmentById(@PathVariable long id){
       return departmentService.findDepartmentById(id);
    }

    @DeleteMapping()
    public void deleteAllDepartments(){
        departmentService.deletaAllDepartments();
    }

}
