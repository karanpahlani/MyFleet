package com.fleet.controller;

import com.fleet.entity.Employee;
import com.fleet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller // similar to @Component
//@ResponseBody
//@CrossOrigin("*")
@RestController
@RequestMapping(value = "employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> findAll(){
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Employee findOne(@PathVariable("id") String empid){
        return service.findOne(empid);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Employee create(@RequestBody Employee employee){
        return service.create(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Employee update(@PathVariable("id") String empid, @RequestBody Employee employee){
        return employee;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable("id") String empid){

    }
}
