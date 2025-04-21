package com.bridgelabz.employeepayroll.controller;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.model.Employee;
import com.bridgelabz.employeepayroll.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired(required = true)
    private EmployeeService employeeService;

    @GetMapping({"","/"})
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/byName")
    public List<Employee> getEmployeeByName(@Valid @RequestParam String name){
        return employeeService.getByName(name);
    }

    @GetMapping("/byId")
    public Optional<Employee> getEmployeeById( @RequestParam Long id){
        return employeeService.getById(id);
    }

    @GetMapping("/bySalary")
    public List<Employee> getEmployeeBySalary(@RequestParam double salary){
        return employeeService.getBySalary(salary);
    }

    @DeleteMapping("/deletion/{id}")
    public ResponseDTO deleteEmployeeById(@PathVariable Long id){
        Employee employee = employeeService.deleteEmployee(id);
        return new ResponseDTO("Employee deleted", employee);
    }

    @PutMapping("/updating")
    public ResponseDTO updateEmployeeById(@RequestParam Long id, @RequestBody EmployeeDTO updates){
        Employee employeeID = employeeService.updateEmployee(id,updates);
        return new ResponseDTO("Employee Updated",employeeID);
    }

    @PostMapping("")
    public ResponseDTO addemployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        Employee savedEmployee = employeeService.addEmployee(employeeDTO);
        return new ResponseDTO("Employee Created Successfully", savedEmployee);
    }

    @GetMapping("/department/{department}")
    public List<Employee> getEmployeeByDepartment(@PathVariable String department){
        return  employeeService.getAllEmployeesByDepartment(department);
    }
}
