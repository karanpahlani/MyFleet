package com.fleet.repository;

import com.fleet.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
    Employee findOne(String empId);
}
