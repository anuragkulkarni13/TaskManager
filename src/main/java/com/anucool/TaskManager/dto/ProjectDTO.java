package com.anucool.TaskManager.dto;

import com.anucool.TaskManager.entity.User;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

public class ProjectDTO {

    private Long projectId;
    private String projectName;
    private User user;

    public ProjectDTO() {
    }

    public ProjectDTO(Long projectId, @NonNull String projectName, User user) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.user = user;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @NonNull
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(@NonNull String projectName) {
        this.projectName = projectName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", user=" + user +
                '}';
    }
}
