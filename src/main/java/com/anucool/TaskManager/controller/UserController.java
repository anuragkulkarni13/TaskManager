package com.anucool.TaskManager.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping()
    public String createUser()
    {
        return "User Created";
    }

    @GetMapping()
    public String getUser()
    {
        return "User Fetched";
    }

    @PutMapping()
    public String updateUser()
    {
        return "User Updated";
    }

    @DeleteMapping()
    public String deleteUser()
    {
        return "User Deleted";
    }
}
