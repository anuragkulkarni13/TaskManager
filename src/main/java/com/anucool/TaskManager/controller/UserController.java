package com.anucool.TaskManager.controller;

import com.anucool.TaskManager.dto.UserDTO;
import com.anucool.TaskManager.entity.User;
import com.anucool.TaskManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public int createUser(@RequestBody UserDTO userDTO)
    {
        return userService.createUser(userDTO);
    }

    @GetMapping()
    public List<UserDTO> getUser()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/{userName}")
    public UserDTO getUserByUserName(@PathVariable String userName)
    {
        return userService.getUserByName(userName);
    }

    @PutMapping("{userName}")
    public UserDTO updateUser(@PathVariable String userName, @RequestBody UserDTO userDTO)
    {
        return userService.updateUser(userName, userDTO);
    }

    @DeleteMapping("{userName}")
    public int deleteUser(@PathVariable String userName)
    {
        return userService.deleteUser(userName);
    }
}
