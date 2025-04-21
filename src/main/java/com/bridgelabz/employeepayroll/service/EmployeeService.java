package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.Exception.EmployeePayrollException;
import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.model.Employee;
import com.bridgelabz.employeepayroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeeService {


    private static final String template = "Welcome, %s";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public List<Employee> getByName(String name){
        return employeeRepository.findByName(name);
    }

    public Optional<Employee> getById(Long id){
        return employeeRepository.findById(id);
    }

    public List<Employee> getBySalary(double salary){
        return employeeRepository.findBySalary(salary);
    }

   // ResponseDTO deleteEmployee(Long id);
    public Employee deleteEmployee(Long id){
        Employee employeeToDelete = employeeRepository.findById(id).orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
        employeeRepository.delete(employeeToDelete);
        return  employeeToDelete;
    }

    public Employee updateEmployee(Long id, EmployeeDTO updates){
        Optional<Employee> employeeToUpdate = employeeRepository.findById(id);

        if(employeeToUpdate.isPresent()) {
            Employee updatedEmployee = employeeToUpdate.get();
            updatedEmployee.updateEmployeeData(updates);
            return  employeeRepository.save(updatedEmployee);

        } else {
            throw new EmployeePayrollException("Employee Not Found");
        }
    }

    public Employee addEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee(employeeDTO);
        return  employeeRepository.save(employee);
    }


    public List<Employee> getAllEmployeesByDepartment(String department){
        return  employeeRepository.findAllByDepartment(department);


    }

}
