package com.example.employee_api_management.execption;

public class DepartmentNotFoundException
        extends RuntimeException {

    public DepartmentNotFoundException(String message) {
        super(message);
    }
}