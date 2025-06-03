package com.anucool.TaskManager.mapper;

import com.anucool.TaskManager.dto.ProjectDTO;
import com.anucool.TaskManager.dto.UserDTO;
import com.anucool.TaskManager.entity.Project;
import com.anucool.TaskManager.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectMapper implements mapper<ProjectDTO, Project>{

    @Override
    public ProjectDTO toDto(Project entity) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(entity.getProjectId());
        projectDTO.setProjectName(entity.getProjectName());
        projectDTO.setUser(entity.getUser());
        return projectDTO;
    }

    @Override
    public Project toEntity(ProjectDTO dto) {
        Project project = new Project();
        project.setProjectId(dto.getProjectId());
        project.setProjectName(dto.getProjectName());
        project.setUser(dto.getUser());
        return project;
    }

    @Override
    public List<ProjectDTO> toDtoList(List<Project> projectList) {
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        for(Project project : projectList)
        {
            ProjectDTO projectDTO = toDto(project);
            projectDTOList.add(projectDTO);
        }
        return projectDTOList;
    }

    @Override
    public List<Project> toEntityList(List<ProjectDTO> dtoList) {
        List<Project> projectList = new ArrayList<>();
        for(ProjectDTO projectDTO : dtoList)
        {
            Project project = toEntity(projectDTO);
            projectList.add(project);
        }
        return projectList;
    }
}
