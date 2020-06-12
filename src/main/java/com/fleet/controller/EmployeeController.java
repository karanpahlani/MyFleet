package com.fleet.controller;

import com.fleet.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller // similar to @Component
//@ResponseBody
@RestController
@RequestMapping(value = "employees")
public class EmployeeController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> findAll(){
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Employee findOne(@PathVariable("id") String empid){
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Employee create(@RequestBody Employee employee){
        return employee;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Employee update(@PathVariable("id") String empid, @RequestBody Employee employee){
        return employee;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable("id") String empid){

    }
}
