package com.controle.controle1.controller;

package com.controle.controle1.controller;

import com.controle.controle1.dao.ProjectDao;
import com.controle.controle1.dao.ProjectDaoImpl;
import com.controle.controle1.model.Project;
import com.controle.controle1.service.ProjectService;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Map;

@ManagedBean
@RequestScoped
public class ProjectBean {

    private List<Project> projects;
    private ProjectDao projectDao = new ProjectDaoImpl();
    private ProjectService projectService = new ProjectService(projectDao);
    private Project newProject;
    private int id;
    private String name;
    private double budget;

    private int pageNumber = 1;
    private int firstRowIndex;
    private int rowsPerPage;

    public ProjectBean() {
        newProject = new Project();
    }

    public List<Project> getProjects() {
        projects = projectService.getAllProjects();
        return projects;
    }

    public String save() {
        projectService.addProject(newProject);
        resetFields();
        return "table?faces-redirect=true";
    }

    public void retrieveProjectDataForEdit() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String projectIdParam = params.get("projectId");
        if (projectIdParam != null) {
            int projectId = Integer.parseInt(projectIdParam);
            Project project = projectService.getProjectById(projectId);
            if (project != null) {
                this.id = project.getPid();
                this.name = project.getName();
                this.budget = project.getBudget();
            }
        }
    }

    private void resetFields() {
        name = null;
        budget = 0.0;
    }

    public String deleteProject(int projectId) {
        if (projectId <= 0) {
            return "error";
        }

        projectService.deleteProject(projectId);
        projects = projectService.getAllProjects();
        return "success";
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
