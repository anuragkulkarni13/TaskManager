package com.anucool.TaskManager.controller;

import com.anucool.TaskManager.dto.ProjectDTO;
import com.anucool.TaskManager.dto.UserDTO;
import com.anucool.TaskManager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping()
    public int createProject(@RequestBody ProjectDTO projectDTO)
    {
        return projectService.createProject(projectDTO);
    }

    @GetMapping()
    public List<ProjectDTO> getProject()
    {
        return projectService.getAllProjects();
    }

    @GetMapping("/{projectName}")
    public ProjectDTO getProjectByUserName(@PathVariable String projectName)
    {
        return projectService.getProjectByName(projectName);
    }

    @PutMapping("/{projectName}")
    public ProjectDTO updateProject(@PathVariable String projectName, @RequestBody ProjectDTO projectDTO)
    {
        return projectService.updateProject(projectName, projectDTO);
    }

    @DeleteMapping("/{projectName}")
    public int deleteProject(@PathVariable String projectName)
    {
        return projectService.deleteProject(projectName);
    }

}
