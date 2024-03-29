package com.controle.controle1.dao;





import com.controle.controle1.model.Employee;

import java.util.List;

public interface EmployeeDao{
    void addEmployee(Employee employee);
    void deleteEmployee(int employeeId);
    Employee getEmployeeById(int employeeId);

    Employee getEmployeeByName(int name);

    List<Employee> getAllEmployees();
    Employee getEmployeeByName(String name);

    Employee getEmployeeByEmail(String email);

}

