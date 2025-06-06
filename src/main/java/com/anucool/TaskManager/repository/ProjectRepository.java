package com.anucool.TaskManager.repository;

import com.anucool.TaskManager.entity.Project;
import com.anucool.TaskManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findByProjectName(String projectname);
}
