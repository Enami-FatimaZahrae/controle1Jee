package com.controle.controle1.controller;
import com.controle.controle1.dao.EmployeeDao;
import com.controle.controle1.dao.EmployeeDaoImpl;
import com.controle.controle1.model.Employee;
import com.controle.controle1.model.Project;
import com.controle.controle1.service.EmployeeService;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;
import java.util.Map;

@ManagedBean
@RequestScoped
public class EmployeeBean {

    private List<Employee> employees;
    private EmployeeDao employeeDao=new EmployeeDaoImpl();
    private EmployeeService employeeService=new EmployeeService(employeeDao);
    private Employee newEmployee;
    private int id;
    private String name;
    private String email;
    private List<String> skills;
    private List<Project> projets;
    private Employee.Poste poste;

    private int pageNumber = 1;
    private int firstRowIndex;
    private int rowsPerPage;
    private String language;



    public EmployeeBean() {
        newEmployee = new Employee();
    }
    public String getLanguage() {

        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }




    public List<Employee> GetEmployees() {
        EmployeeDao employeeDao=new EmployeeDaoImpl();
        EmployeeService employeeService = new EmployeeService(employeeDao);
        employees =employeeService.getAllEmployees() ;
        return employees;
    }

    public String save() {
        newEmployee = new Employee(name, email,skills,projets);
        employeeService.addEmployee(newEmployee);
        resetFields();
        return "table?faces-redirect=true";
    }
    public void retrieveEmployeeDataForEdit() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String employeeIdParam = params.get("employeeId");
        System.out.println(employeeIdParam);
        if (employeeIdParam != null) {
            int employeeId = Integer.parseInt(employeeIdParam);
            Employee employee = employeeService.getEmployeeById(employeeId);
            System.out.println(employee);
            if (employee != null) {
                this.id = employee.getId();
                this.name = employee.getName();
                this.email = employee.getEmail();
                this.skills = employee.getSkills();
                this.projets= employee.getProjets();
            }
        }
    }

    private void resetFields() {
        name = null;
        email = null;
        skills = null;
        projets = null;
    }
    public String deleteEmployee(int employeeId) {
        if (employeeId <= 0) {
            return "error";
        }


        EmployeeDao employeeDao=new EmployeeDaoImpl();
        EmployeeService employeeService = new EmployeeService(employeeDao);
        System.out.println("avant ");
        employeeService.deleteEmployee(employeeId);
        System.out.println("apres ");
        employees = employeeService.getAllEmployees();
        return "success";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<Project> getProjets() {
        return projets;
    }

    public void setProjets(List<Project> projets) {
        this.projets = projets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void selectEmployeeByName(String name) {
        Employee selectedEmployee = employeeService.getEmployeeByName(name);
    }





}

