package com.fleet.entity;
import javax.persistence.*;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "Employee.findAll", query = "SELECT emp from Employee emp order by emp.email Desc " )
})
public class Employee {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;
    private String name;
    @Column(unique = true)
    private String email;
    private int salary;

    public Employee(){
        this.id = UUID.randomUUID().toString();
    }
    public Employee(String name, String email, int salary) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}
