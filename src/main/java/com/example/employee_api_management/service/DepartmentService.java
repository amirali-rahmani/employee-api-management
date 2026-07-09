package com.example.employee_api_management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_api_management.dto.DepartmentRequestDTO;
import com.example.employee_api_management.dto.DepartmentResponseDTO;
import com.example.employee_api_management.dto.EmployeeRequestDTO;
import com.example.employee_api_management.dto.EmployeeResponseDTO;
import com.example.employee_api_management.entity.Department;
import com.example.employee_api_management.entity.Employee;
import com.example.employee_api_management.execption.EmployeeNotFoundException;
import com.example.employee_api_management.repository.DepartmentRepository;

@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;


    public DepartmentResponseDTO addDepartment(DepartmentRequestDTO dto){
        Department department = mapToEntity(dto);
        departmentRepository.save(department);

        return mapToDTO(department);
    }

    public List<DepartmentResponseDTO> findAllDepartment(){

            return departmentRepository.findAll()
            .stream()
            .map(this::mapToDTO)
            .collect(Collectors.toList());
    }

    public DepartmentResponseDTO findDepartmentById(Long id){
         Department department = departmentRepository.findById(id).orElseThrow(() ->
                        new EmployeeNotFoundException("Employee not found with id: " + id));

         return mapToDTO(department);               
    }

    public void deletaAllDepartments(){
        departmentRepository.deleteAll();
    }

    private Department mapToEntity(DepartmentRequestDTO dto) {

        Department department = new Department();

        department.setName(dto.getName());
        department.setDescription(dto.getDescription());

        return department;
    }

    private DepartmentResponseDTO mapToDTO(Department department) {

        DepartmentResponseDTO dto = new DepartmentResponseDTO();

        dto.setId(department.getId());
        dto.setName(department.getName());
        dto.setDescription(department.getDescription());

        return dto;
    }

}
