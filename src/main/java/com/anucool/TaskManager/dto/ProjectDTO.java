package com.anucool.TaskManager.dto;

import com.anucool.TaskManager.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    private Long projectId;
    private String projectName;
    private User user;

}
