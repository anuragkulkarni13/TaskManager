package com.anucool.TaskManager.mapper;

import com.anucool.TaskManager.dto.UserDTO;
import com.anucool.TaskManager.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper implements mapper<UserDTO, User>{

    @Override
    public UserDTO toDto(User entity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(entity.getUserId());
        userDTO.setUserName(entity.getUserName());
        userDTO.setProjects(userDTO.getProjects());
        return userDTO;
    }

    @Override
    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setUserName(dto.getUserName());
        user.setProjects(dto.getProjects());
        return user;
    }

    @Override
    public List<UserDTO> toDtoList(List<User> userList) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for(User user : userList)
        {
            UserDTO userDto = toDto(user);
            userDTOList.add(userDto);
        }
        return userDTOList;
    }

    @Override
    public List<User> toEntityList(List<UserDTO> dtoList) {
        List<User> userList = new ArrayList<>();
        for(UserDTO userDTO : dtoList)
        {
            User user = toEntity(userDTO);
            userList.add(user);
        }
        return userList;
    }
}
