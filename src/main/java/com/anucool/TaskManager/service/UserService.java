package com.anucool.TaskManager.service;

import com.anucool.TaskManager.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserService {

    public UserDTO createUser(UserDTO userDTO);
    public List<UserDTO> getAllUsers();
    public UserDTO getUserByName(String userName);
    public UserDTO updateUser(String userName, UserDTO userDTO);
    public int deleteUser(String userName);

}
