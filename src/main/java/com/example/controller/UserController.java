package com.example.controller;


import com.example.dto.UserDTO;
import com.example.entity.Users;
import com.example.service.UserService;
import com.example.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "用户模块")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public Result login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO);
    }

    @GetMapping
    @ApiOperation(value = "获取用户列表")
    public Result getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取用户详情")
    public Result getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping
    @ApiOperation(value = "更新用户")
    public Result updateUser(@RequestBody Users user){
        return userService.updateUser(user);
    }

    @PostMapping
    @ApiOperation(value = "添加用户")
    public Result addUser(@RequestBody Users user){
        return userService.addUser(user);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户")
    public Result deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    @GetMapping("/query")
    @ApiOperation(value = "查询用户")
    public Result query(@RequestParam String username,@RequestParam String email){
        return userService.query(username,email);
    }




}
