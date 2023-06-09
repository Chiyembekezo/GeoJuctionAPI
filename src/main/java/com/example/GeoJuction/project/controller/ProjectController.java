package com.example.GeoJuction.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.GeoJuction.project.model.Project;
import com.example.GeoJuction.project.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
    
    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public String getProjects(Model model)
    {
        List<Project> projectList = projectService.getProjects();
        model.addAttribute("projects", projectList);
        return "project/project_list";
    }

    @PostMapping
    public String save(Project project)
    {
        projectService.save(project);
        return "redirect:/project/projects";
    }
}
