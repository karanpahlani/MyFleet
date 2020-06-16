package com.fleet.service;


import com.fleet.entity.Employee;
import com.fleet.exception.EmployeeAlreadyExists;
import com.fleet.exception.EmployeeNotFoundException;
import com.fleet.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired //can also use constructor based dependency injection
    EmployeeRepository repository;


    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return (List<Employee>) repository.findAll(); //No business logic required
    }


    @Transactional(readOnly = true)
    public Employee findOne(String empId) {
        Optional<Employee> employee = repository.findById(empId);
        //Business Logic here
        if(!employee.isPresent()){
            throw new EmployeeNotFoundException("Employee of id: "+ empId+ "NOT FOUND");
        }
        else {
            return employee.get();
        }
    }


    @Transactional
    public Employee create(Employee employee) {
        Optional<Employee> existing = repository.findByEmail(employee.getEmail());

        if (existing.isPresent()){
            System.out.println("exceptin time!");
            throw new EmployeeAlreadyExists("Employee with email" + employee.getEmail() + "already exists: ");
        }
        return repository.save(employee);
    }


    @Transactional
    public Employee update(String id, Employee employee) {
        Optional<Employee> emp = repository.findById(employee.getId());
        if(!emp.isPresent()){

            throw new EmployeeNotFoundException("Employee does not exist exists with id: "+ employee.getId());
        }
        return repository.save(employee);
    }


    public void delete(String empId) {
        Optional<Employee> emp = repository.findById(empId);
        if(!emp.isPresent()){
            throw new EmployeeNotFoundException("Employee does not exist exists with id: "+ empId);
        }
        repository.delete(emp.get());

    }
}
