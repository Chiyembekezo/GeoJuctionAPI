package com.example.GeoJuction.project.restapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.GeoJuction.project.model.Project;
import com.example.GeoJuction.project.restapi.dto.ProjectDto;
import com.example.GeoJuction.project.restapi.model.request.ProjectRequestModel;
import com.example.GeoJuction.project.restapi.model.response.ProjectRest;
import com.example.GeoJuction.project.restapi.service.ProjectRestService;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectRestController {
    @Autowired
    private ProjectRestService projectRestService;


    @CrossOrigin
    @GetMapping
    public @ResponseBody  Map<String, Object> getProjects() {
        List<Project>  getProjectList = projectRestService.getProjects();
        

        Map<String, Object> response = new HashMap<>();
        response.put("project",  getProjectList);
        return response;
    }

    @CrossOrigin
    @PostMapping
    public ProjectRest save(@RequestBody ProjectRequestModel projectDetails)
    {
       
        var projectDto = new ProjectDto();

        BeanUtils.copyProperties(projectDetails, projectDto);

        ProjectDto createdProject = projectRestService.save(projectDto);
        var returnValue = new ProjectRest();

        BeanUtils.copyProperties(createdProject, returnValue);
        return returnValue;
    }
}
