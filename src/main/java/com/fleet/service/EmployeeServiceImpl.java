package com.fleet.service;


import com.fleet.entity.Employee;
import com.fleet.exception.EmployeeAlreadyExists;
import com.fleet.exception.EmployeeNotFoundException;
import com.fleet.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.fleet.exception.EmployeeNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired //can also use constructor based dependency injection
    EmployeeRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return repository.findAll(); //No business logic required
    }

    @Override
    @Transactional(readOnly = true)
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


    @Transactional
    public Employee create(Employee employee) {
        List<Employee> existing = repository.findByEmail(employee.getEmail());
        System.out.println("our results: " + existing );
        if (existing.size() != 0){
            System.out.println("exception time!");
            throw new EmployeeAlreadyExists("Employee with email"+  employee.getEmail() + "already exists: "  );
        }
        return repository.create(employee);
    }


    @Transactional
    public Employee update(String id, Employee employee) {
        return null;
    }


    public void delete(String empId) {

    }
}
