package com.anucool.TaskManager.service;

import com.anucool.TaskManager.dto.ProjectDTO;
import com.anucool.TaskManager.dto.UserDTO;

import java.util.List;

public interface ProjectService{

    public int createProject(ProjectDTO projectDTO);
    public List<ProjectDTO> getAllProjects();
    public ProjectDTO getProjectByName(String projectName);
    public ProjectDTO updateProject(String projectName, ProjectDTO projectDTO);
    public int deleteProject(String projectName);
}
