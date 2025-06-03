package com.anucool.TaskManager.dto;

import com.anucool.TaskManager.entity.Project;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private Long userId;
    private String userName;
    private List<Project> projects = new ArrayList<>();

    public UserDTO() {
    }

    public UserDTO(Long userId, @NonNull String userName, List<Project> projects) {
        this.userId = userId;
        this.userName = userName;
        this.projects = projects;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", projects=" + projects +
                '}';
    }
}
