package com.controle.controle1.dao;

import com.controle.controle1.model.Employee;
import jakarta.persistence.*;
import java.util.List;
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext

    private EntityManagerFactory emf;
    private EntityManager em;

    public EmployeeDaoImpl() {
        emf = Persistence.createEntityManagerFactory("emp");
        em = emf.createEntityManager();
    }
    @Override
    public void addEmployee(Employee employee) {
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
    }

    @Override
    public void deleteEmployee(int employeeId) {
        em.getTransaction().begin();
        Employee employee = em.find(Employee.class, employeeId);
        if (employee != null) {
            em.remove(employee);
            em.getTransaction().commit();
        }

    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return em.find(Employee.class, employeeId);
    }
    @Override
    public Employee getEmployeeByName(int name) {
        return em.find(Employee.class, name);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return em.createQuery("SELECT e FROM Employee e", Employee.class)
                .getResultList();
    }

    @Override
    public Employee getEmployeeByName(String name) {
        try {
            return em.createQuery("SELECT e FROM Employee e WHERE e.name = :name", Employee.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }


    public Employee getEmployeeByEmail(String email) {
        try {
            return em.createQuery("SELECT e FROM Employee e WHERE e.email = :email", Employee.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }


}

