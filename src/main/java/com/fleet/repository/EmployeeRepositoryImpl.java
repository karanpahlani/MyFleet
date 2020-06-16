package com.fleet.repository;

import com.fleet.entity.Employee;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

    @Override
    public Employee create(Employee employee) {
        System.out.println("about to persist" + employee);
        entityManager.persist(employee);
        return employee;
    }

    @Override
    public List findByEmail(String email) {
        List results = entityManager.createQuery("SELECT emp FROM Employee emp where emp.email = :value1")
                .setParameter("value1", email).getResultList();
        return results;
    }
}
