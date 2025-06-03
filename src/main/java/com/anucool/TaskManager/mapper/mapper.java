package com.anucool.TaskManager.mapper;

import com.anucool.TaskManager.dto.ProjectDTO;
import com.anucool.TaskManager.dto.UserDTO;
import com.anucool.TaskManager.entity.Project;
import com.anucool.TaskManager.entity.User;

import java.util.List;

public interface mapper<D, E> {

    public D toDto(E entity);
    public E toEntity(D dto);
    public List<D> toDtoList(List<E> entity);
    public List<E> toEntityList(List<D> dto);

}
