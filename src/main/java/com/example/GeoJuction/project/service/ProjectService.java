package com.example.GeoJuction.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GeoJuction.project.model.Project;
import com.example.GeoJuction.project.repository.ProjectRepository;

@Service
public class ProjectService {
    
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getProjects()
    {
       final List<Project> projects = projectRepository.findAll();
       return projects;
    }

    public void save(Project project)
    {
        projectRepository.save(project);
    }
}
