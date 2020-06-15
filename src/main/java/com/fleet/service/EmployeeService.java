package com.fleet.service;

import com.fleet.entity.Employee;

import java.util.List;


public interface EmployeeService {

        List<Employee> findAll();
        Employee findOne(String empId);
        Employee create(Employee employee);
        Employee update(String id, Employee employee);
        void delete(String empId);
}

