package com.example.GeoJuction.project.restapi.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GeoJuction.project.model.Project;
import com.example.GeoJuction.project.repository.ProjectRepository;
import com.example.GeoJuction.project.restapi.dto.ProjectDto;
import com.example.GeoJuction.project.restapi.service.ProjectRestService;

@Service
public class ProjectRestServiceImpl implements ProjectRestService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @Override
    public ProjectDto save(ProjectDto projectDto) {

        var project = new Project();
        BeanUtils.copyProperties(projectDto, project);

        Project storedProjectDetails = projectRepository.save(project);

        var returnValue = new ProjectDto();
        BeanUtils.copyProperties(storedProjectDetails, returnValue);

        return returnValue;
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void getById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }
    
}
