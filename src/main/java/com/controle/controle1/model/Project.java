package com.controle.controle1.model;


import jakarta.persistence.*;
import com.controle.controle1.model.Employee;

import java.util.List;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String name;
    private double budget;
    @ManyToMany
    @JoinTable(
            name = "project_employee",
            joinColumns = @JoinColumn(name = "pid"),
            inverseJoinColumns = @JoinColumn(name = "id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"id", "id"})
    )
    private List<Employee> employees;
    public Project(int pid, String name, double budget, List<Employee> employees) {
        this.pid = pid;
        this.name = name;
        this.budget = budget;
        this.employees = employees;
    }

    public Project() {
        super();
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int id) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


}
