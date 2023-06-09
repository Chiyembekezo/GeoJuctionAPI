package com.example.GeoJuction.project.restapi.service;

import java.util.List;

import com.example.GeoJuction.project.model.Project;
import com.example.GeoJuction.project.restapi.dto.ProjectDto;

public interface ProjectRestService {
     //get list of projects
     public List<Project> getProjects();

     ProjectDto save(ProjectDto projectDto);
 
     //delete 
     void delete(int id);
 
     void getById(int id);
}
