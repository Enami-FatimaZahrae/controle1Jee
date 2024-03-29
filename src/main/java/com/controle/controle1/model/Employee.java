package com.controle.controle1.model;

import jakarta.persistence.*;
import com.controle.controle1.model.Project;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private String email;
        private List<String> skills;
       @ManyToMany(mappedBy = "employees")
        private List<Project> projets;
        @Enumerated(EnumType.STRING)
        private Poste poste;

    public Employee(String name, String email, List<String> skills, List<Project> projets) {
        this.name = name;
        this.email = email;
        this.skills = skills;
        this.projets = projets;
    }

    public Employee(String name, String email, List<String> skills, List<Project> projets, Poste poste) {
        this.name = name;
        this.email = email;
        this.skills = skills;
        this.projets = projets;
        this.poste = poste;
    }

    public enum Poste {
        MANAGER, DEV, TEST, DEVOPS, TECH_LEAD;
        }
        public Employee(int id, String name, String email, List<String> skills, Poste poste) {
          this.id = id;
          this.name = name;
          this.email = email;
          this.skills = skills;
          this.poste = poste;
          this.projets = new ArrayList<>();
    }

        public Employee() {
            super();
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

}



