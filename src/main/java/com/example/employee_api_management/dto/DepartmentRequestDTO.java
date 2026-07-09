package com.example.employee_api_management.dto;

import jakarta.validation.constraints.NotBlank;

public class DepartmentRequestDTO {

    @NotBlank(message = "Department name is required")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}