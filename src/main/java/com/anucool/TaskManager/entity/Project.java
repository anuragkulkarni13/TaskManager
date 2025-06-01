package com.anucool.TaskManager.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @NonNull
    private String projectName;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public Project() {
    }

    public Project(Long projectId, @NonNull String projectName, User user) {
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
