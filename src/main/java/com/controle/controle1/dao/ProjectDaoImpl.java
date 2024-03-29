package com.controle.controle1.dao;

import com.controle.controle1.model.Project;
import jakarta.persistence.*;

import java.util.List;

public class ProjectDaoImpl implements ProjectDao {

    @PersistenceContext

    private EntityManagerFactory emf;
    private EntityManager em;

    public ProjectDaoImpl() {
        emf = Persistence.createEntityManagerFactory("pro");
        em = emf.createEntityManager();
    }
    @Override
    public void addProject(Project project) {
        em.getTransaction().begin();
        em.persist(project);
        em.getTransaction().commit();
    }

    @Override
    public void deleteProject(int id) {
        em.getTransaction().begin();
        Project project = em.find(Project.class, id);
        if (project != null) {
            em.remove(project);
            em.getTransaction().commit();
        }

    }

    @Override
    public Project getProjectById(int id) {
        return em.find(Project.class, id);
    }
    @Override
    public Project getProjectByName(int name) {
        return em.find(Project.class, name);
    }

    @Override
    public List<Project> getAllProject() {
        return em.createQuery("SELECT p FROM Project p",Project.class)
                .getResultList();
    }

    public Project getEmployeeByName(String name) {
        try {
            return em.createQuery("SELECT p FROM Project p WHERE p.name = :name", Project.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }



}
