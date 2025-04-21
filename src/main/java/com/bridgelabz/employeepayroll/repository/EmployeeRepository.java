package com.bridgelabz.employeepayroll.repository;

import com.bridgelabz.employeepayroll.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByName(String name);
  //  List<Employee> findbyId(Long id);
    List<Employee> findBySalary(double salary);
    List<Employee> findAllByDepartment(String department);
}
