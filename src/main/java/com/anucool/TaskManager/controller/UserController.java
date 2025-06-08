package com.anucool.TaskManager.controller;

import com.anucool.TaskManager.dto.UserDTO;
import com.anucool.TaskManager.entity.User;
import com.anucool.TaskManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO)
    {
        UserDTO savedUserDto = userService.createUser(userDTO);
        URI uri = URI.create("/user/"+savedUserDto.getUserId());
        //uri is the header
        return ResponseEntity.created(uri).body(savedUserDto);
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getUser()
    {
        List<UserDTO> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<UserDTO> getUserByUserName(@PathVariable String userName)
    {
        UserDTO userDTO = userService.getUserByName(userName);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("{userName}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String userName, @RequestBody UserDTO userDTO)
    {
        UserDTO updatedUserDto = userService.updateUser(userName, userDTO);
        return ResponseEntity.ok(updatedUserDto);
    }

    @DeleteMapping("{userName}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userName)
    {
        userService.deleteUser(userName);
        return ResponseEntity.noContent().build();
    }
}
