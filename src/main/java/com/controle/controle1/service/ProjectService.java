package com.controle.controle1.service;

import com.controle.controle1.dao.ProjectDao;
import com.controle.controle1.model.Project;

import java.util.List;

public class ProjectService {
    private ProjectDao projectDao;

    public ProjectService(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public void deleteProject(int pid) {
        ProjectDao.deleteProject(pid);
    }

    public Project getProjectById(int pid) {
        return projectDao.getProjectById(pid);
    }

    public List<Project> getAllProjects() {
        return projectDao.getAllProject();
    }
    public Project getEmployeeByName(int name) {
        return projectDao.getProjectByName(name);
    }


    public void addProject(Project newProject) {
    }
}
