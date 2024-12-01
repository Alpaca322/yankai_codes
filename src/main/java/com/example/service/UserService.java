package com.example.service;

import com.example.dto.UserDTO;
import com.example.utils.Result;

public interface UserService {

    /**
     * 登录
     * @param userDTO
     * @return
     */
    Result login(UserDTO userDTO);

}
