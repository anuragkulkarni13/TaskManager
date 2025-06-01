package com.anucool.TaskManager.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @PostMapping()
    public String createProject()
    {
        return "Project Created";
    }

    @GetMapping()
    public String getProject()
    {
        return "Project Fetched";
    }

    @PutMapping()
    public String updateProject()
    {
        return "Project Updated";
    }

    @DeleteMapping()
    public String deleteProject()
    {
        return "Project Deleted";
    }

}
