package com.fleet.controller;

import com.fleet.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeController {

    public List<Employee> findAll(){
        return null;
    }

    public Employee findOne(String id){
        return null;
    }

    public Employee create(Employee employee){
        return employee;
    }

    public Employee update(String id, Employee employee){
        return employee;
    }

    public void delete(String id){

    }
}
