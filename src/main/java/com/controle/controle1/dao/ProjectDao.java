package com.controle.controle1.dao;

import com.controle.controle1.model.Project;

import java.util.List;

public interface ProjectDao {
    void addProject(Project project);

    void deleteProject(int id);

    Project getProjectById(int projectId);

    Project getProjectByName(int name);

    List<Project> getAllProject();
}
