package com.example.employee_api_management.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
    
    public Employee(String firstName, String lastName, String jobTitle, String email, BigDecimal salary, LocalDate hireDate) {
         this.firstName = firstName;
         this.lastName = lastName;
         this.jobTitle = jobTitle;
         this.email = email;
         this.salary = salary;
         this.hireDate = hireDate;

    }

    public Employee(){
        
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    
 
    public long getId() {
        return id;
    }

     @Column(name = "first_name")
    private String firstName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

     @Column(name = "last_name")
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

     @Column(name = "job_title")
    private String jobTitle;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

     @Column(name = "email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     @Column(name = "salary")
    private BigDecimal salary;

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

     @Column(name = "hire_date")
    private LocalDate hireDate;

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}
