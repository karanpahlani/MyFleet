package com.fleet.service;


import com.fleet.entity.Employee;
import com.fleet.exception.EmployeeNotFoundException;
import com.fleet.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.fleet.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired //can also use constructor based dependency injection
    EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll(); //No business logic required
    }

    @Override
    public Employee findOne(String empId) {
        Employee employee = repository.findOne(empId);
        //Business Logic here
        if(employee == null){
            throw new EmployeeNotFoundException("Employee of id: "+ empId+ "NOT FOUND");
        }
        else {
            return employee;
        }
    }

    @Override
    public Employee create(Employee employee) {
        return null;
    }

    @Override
    public Employee update(String id, Employee employee) {
        return null;
    }

    @Override
    public void delete(String empId) {

    }
}
