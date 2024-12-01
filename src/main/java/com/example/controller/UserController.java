package com.example.controller;


import com.example.dto.UserDTO;
import com.example.entity.Users;
import com.example.service.UserService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public Result login(@RequestParam UserDTO userDTO) {
        return userService.login(userDTO);
    }

    @GetMapping
    public Result getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public Result getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping
    public Result updateUser(@RequestParam Users user){
        return userService.updateUser(user);
    }

    @PostMapping
    public Result addUser(@RequestParam Users user){
        return userService.addUser(user);
    }





}
