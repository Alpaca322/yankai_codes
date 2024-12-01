package com.example.service.impl;

import com.example.dto.UserDTO;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
