package com.fleet.repository;

import com.fleet.entity.Employee;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findAll", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findOne(String empId) {
        return entityManager.find(Employee.class, empId);
    }
}
