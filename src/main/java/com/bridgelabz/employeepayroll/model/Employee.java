package com.bridgelabz.employeepayroll.model;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee_payroll")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;
    private String name;
    private double salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="employee_department", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "department")
    private List<String> department;

    public Employee(EmployeeDTO employeeDTO){
          this.updateEmployeeData(employeeDTO);
    }

    public void updateEmployeeData(EmployeeDTO employeeDTO){
        this.name = employeeDTO.name;
        this.gender = employeeDTO.gender;
        this.salary = employeeDTO.salary;
        this.startDate = employeeDTO.startDate;
        this.note = employeeDTO.note;
        this.profilePic = employeeDTO.profilePic;
        this.department = employeeDTO.department;
    }
//
//    public Employee(Long employeeId, String name, double salary){
//        this.employeeId = employeeId;
//        this.name = name;
//        this.salary = salary;
//    }
//
//    public void setName(String name){
//        this.name = name;
//    }
//
//    public void setEmployeeId(Long employeeId){
//        this.employeeId = employeeId;
//    }
//
//    public void setSalary(double salary){
//        this.salary = salary;
//    }
//
//    public String getName(){
//        return name;
//    }
//
//    public Long getEmployeeId(){
//        return employeeId;
//    }
//
//    public double getSalary(){
//        return salary;
//    }
//
//    @Override
//    public String toString(){
//        return  name + " with " + employeeId + " his/her salary is " + salary;
//    }
}
