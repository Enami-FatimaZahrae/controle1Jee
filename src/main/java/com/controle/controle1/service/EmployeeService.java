package com.controle.controle1.service;

import com.controle.controle1.dao.EmployeeDao;
import com.controle.controle1.model.Employee;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

public class EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    public void addEmployee(Employee employee) {
        Employee existingEmployee = employeeDao.getEmployeeByEmail(employee.getEmail());
        if (existingEmployee != null) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Employee already exists",
                            "Employee with email " + employee.getEmail() + " already exists."));
            return;
        }
        this.employeeDao.addEmployee(employee);
    }


    public void deleteEmployee(int employeeId) {
        employeeDao.deleteEmployee(employeeId);
    }

    public Employee getEmployeeById(int employeeId) {
        return employeeDao.getEmployeeById(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
    public Employee getEmployeeByName(int name) {
        return employeeDao.getEmployeeById(name);
    }


}

