package com.fleet.repository;

import com.fleet.entity.Employee;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{


    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("rohit", "rpah@gmail.com", 874783));
        employeeList.add(new Employee("Kaaran", "pahlani@gmail.com", 94843434));
        employeeList.add(new Employee("kalu", "kamal@gmail.com", 957533));
        return employeeList;
    }

    @Override
    public Employee findOne(String empId) {
        if(empId.equals("5533")){
            return new Employee("kjhsad", "fsdf@gmail.com", 874783);
        }
        else{
            return null;
        }


    }
}
