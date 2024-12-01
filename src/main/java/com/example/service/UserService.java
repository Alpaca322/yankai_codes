package com.example.service;

import com.example.dto.UserDTO;
import com.example.entity.Users;
import com.example.utils.Result;

public interface UserService {

    /**
     * 登录
     * @param userDTO
     * @return
     */
    Result login(UserDTO userDTO);

    /**
     * 获取用户列表
     * @return
     */
    Result getUsers();

    /**
     * 更新用户
     * @param user
     * @return
     */
    Result updateUser(Users user);

    /**
     * 添加用户
     * @param user
     * @return
     */
    Result addUser(Users user);

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    Result getUserById(Long id);
}
