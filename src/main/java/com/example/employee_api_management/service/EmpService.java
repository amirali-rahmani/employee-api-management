package com.example.employee_api_management.service;

import com.example.employee_api_management.dto.EmployeeRequestDTO;
import com.example.employee_api_management.dto.EmployeeResponseDTO;
import com.example.employee_api_management.entity.Department;
import com.example.employee_api_management.entity.Employee;
import com.example.employee_api_management.repository.DepartmentRepository;
import com.example.employee_api_management.repository.EmployeeRepository;
import com.example.employee_api_management.execption.DepartmentNotFoundException;
import com.example.employee_api_management.execption.EmailAlreadyExistsException;
import com.example.employee_api_management.execption.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    // =========================
    // CREATE EMPLOYEE
    // =========================
    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO dto) {

        // check email uniqueness
        if (employeeRepository.existsByEmail(dto.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        Employee employee = mapToEntity(dto);
        Employee saved = employeeRepository.save(employee);

        return mapToDTO(saved);
    }

    // =========================
    // GET ALL EMPLOYEES
    // =========================
    public List<EmployeeResponseDTO> findAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // =========================
    // GET EMPLOYEE BY ID
    // =========================
    public EmployeeResponseDTO findEmployeeById(long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee not found with id: " + id));

        return mapToDTO(employee);
    }

    // =========================
    // DELETE ALL EMPLOYEES
    // =========================
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }

    // =========================
    // MAPPING METHODS
    // =========================

    private Employee mapToEntity(EmployeeRequestDTO dto) {

        Department department =
        departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() ->
                        new DepartmentNotFoundException(
                                "Department not found"));

        Employee employee = new Employee();

        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setJobTitle(dto.getJobTitle());
        employee.setEmail(dto.getEmail());
        employee.setSalary(dto.getSalary());
        employee.setHireDate(dto.getHireDate());
        employee.setDepartment(department);

        return employee;
    }

    private EmployeeResponseDTO mapToDTO(Employee employee) {

        EmployeeResponseDTO dto = new EmployeeResponseDTO();

        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setJobTitle(employee.getJobTitle());
        dto.setEmail(employee.getEmail());
        dto.setSalary(employee.getSalary());
        dto.setHireDate(employee.getHireDate());
        dto.setDepartmentId(employee.getDepartment().getId());
        dto.setDepartmentName(employee.getDepartment().getName());

        return dto;
    }
}