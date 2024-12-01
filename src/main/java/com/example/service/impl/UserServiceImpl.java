package com.example.service.impl;

import com.example.dto.UserDTO;
import com.example.entity.Users;
import com.example.exception.BaseException;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public Result login(UserDTO userDTO) {

        if (userMapper.getPassword(userDTO.getUsername()) == null) {
            return Result.error("用户名或密码错误");
        }

        String password = userMapper.getPassword(userDTO.getUsername());

        if (password.equals(userDTO.getPassword())) {
            return Result.success("登录成功");
        } else {
            return Result.error("用户名或密码错误");
        }
    }


    public Result getUsers() {
        List<Users> users = userMapper.getUsers();
        return Result.success(users);
    }

    public Result updateUser(Users user) {
        if (user.getUsername() == null || user.getUsername().isEmpty()){
            throw new BaseException("用户名不能为空");
        }

        userMapper.updateUser(user);

        return Result.success("更新成功");
    }

    public Result addUser(Users user) {
        if (user.getUsername() == null || user.getUsername().isEmpty()){
            throw new BaseException("用户名不能为空");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()){
            throw new BaseException("密码不能为空");
        }
        user.setCreatedAt(LocalDateTime.now());
        user.setStatus("Active");
        userMapper.addUser(user);
        return Result.success("添加成功");
    }

    public Result getUserById(Long id) {
        if (id == null){
            throw new BaseException("id不能为空");
        }
        Users user = userMapper.getUserById(id);
        return Result.success(user);
    }
}
