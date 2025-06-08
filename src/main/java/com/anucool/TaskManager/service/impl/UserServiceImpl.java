package com.anucool.TaskManager.service.impl;

import com.anucool.TaskManager.dto.UserDTO;
import com.anucool.TaskManager.entity.User;
import com.anucool.TaskManager.exceptions.ResourceNotFoundException;
import com.anucool.TaskManager.mapper.UserMapper;
import com.anucool.TaskManager.repository.UserRepository;
import com.anucool.TaskManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public int createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        userRepository.save(user);
        return 0;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDtoList = userMapper.toDtoList(users);
        return userDtoList;
    }

    @Override
    public UserDTO getUserByName(String userName) {
        User user = userRepository.findByUserName(userName);
        if(user != null)
        {
            UserDTO userDTO = userMapper.toDto(user);
            return userDTO;
        }
        else {
            throw new ResourceNotFoundException("User with the userName "+userName+" not found.");
        }
    }

    @Override
    public UserDTO updateUser(String userName, UserDTO userDTO) {
        User user = userRepository.findByUserName(userName);
        if(user != null)
        {
            user.setUserName(userDTO.getUserName());
            //Following line is having issues when updating with orphan removals
//          user.setProjects(userDTO.getProjects());
            userRepository.save(user);
            return userMapper.toDto(user);
        } else {
            throw new ResourceNotFoundException("User with the userName "+userName+" not found. Update request Cancelled");
        }
    }

    @Override
    public int deleteUser(String userName) {
        User user = userRepository.findByUserName(userName);
        if(user != null)
        {
            userRepository.delete(user);
            return 0;
        }
        else {
            throw new ResourceNotFoundException("User with the userName "+userName+" not found. Delete request Cancelled");
        }
    }
}
