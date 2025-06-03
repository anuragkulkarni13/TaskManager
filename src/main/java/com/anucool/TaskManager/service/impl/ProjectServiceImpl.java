package com.anucool.TaskManager.service.impl;

import com.anucool.TaskManager.dto.ProjectDTO;
import com.anucool.TaskManager.dto.UserDTO;
import com.anucool.TaskManager.entity.Project;
import com.anucool.TaskManager.entity.User;
import com.anucool.TaskManager.mapper.ProjectMapper;
import com.anucool.TaskManager.mapper.UserMapper;
import com.anucool.TaskManager.repository.ProjectRepository;
import com.anucool.TaskManager.repository.UserRepository;
import com.anucool.TaskManager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectMapper projectMapper;

    @Override
    public int createProject(ProjectDTO projectDTO) {
        Project project = projectMapper.toEntity(projectDTO);
        projectRepository.save(project);
        return 0;
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        List<ProjectDTO> projectDTOList = projectMapper.toDtoList(projects);
        return projectDTOList;
    }

    @Override
    public ProjectDTO getProjectByName(String projectName) {
        Project project = projectRepository.findByProjectName(projectName);
        ProjectDTO projectDTO = projectMapper.toDto(project);
        return projectDTO;
    }

    @Override
    public ProjectDTO updateProject(String projectName, ProjectDTO projectDTO) {
        Project project = projectRepository.findByProjectName(projectName);
        project.setProjectName(projectDTO.getProjectName());
//        project1.setUser(projectDTO.getUser());
        projectRepository.save(project);
        return projectMapper.toDto(project);
    }

    @Override
    public int deleteProject(String projectName) {
        Project project = projectRepository.findByProjectName(projectName);
        projectRepository.delete(project);
        return 0;
    }
}
