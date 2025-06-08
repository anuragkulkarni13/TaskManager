package com.anucool.TaskManager.service.impl;

import com.anucool.TaskManager.dto.UserDTO;
import com.anucool.TaskManager.entity.User;
import com.anucool.TaskManager.exceptions.InvalidResourceException;
import com.anucool.TaskManager.exceptions.ResourceNotFoundException;
import com.anucool.TaskManager.mapper.UserMapper;
import com.anucool.TaskManager.repository.UserRepository;
import com.anucool.TaskManager.service.UserService;
import jakarta.transaction.Transactional;
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
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        if(userDTO.getUserName() == null || userDTO.getUserName().trim().isEmpty())
        {
            throw new InvalidResourceException("Invalid User. UserName must not be Empty");
        }
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        UserDTO savedUserDto = userMapper.toDto(savedUser);

        return savedUserDto;
    }

    @Override
    @Transactional
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDtoList = userMapper.toDtoList(users);
        return userDtoList;
    }

    @Override
    @Transactional
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
    @Transactional
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
    @Transactional
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
