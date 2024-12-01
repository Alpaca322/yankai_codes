package com.example;

import com.example.controller.DataRecordsController;
import com.example.controller.UserController;
import com.example.dto.UserDTO;
import com.example.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class TrafficApplicationTests {

    @Autowired
    private DataRecordsController dataRecordsController;
    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
        System.out.println(dataRecordsController.getById(1L));
    }

    @Test
    void testLogin(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("admin");
        userDTO.setPassword("123");
        System.out.println(userController.login(userDTO));

        userDTO.setUsername("zhangsan");
        System.out.println(userController.login(userDTO));

    }

    @Test
    void testGetUsers(){
        System.out.println(userController.getUsers());
    }

    @Test
    void testAddUser(){
        Users user = new Users();
        user.setUsername("lisi");
        user.setPassword("123456");
        user.setEmail("12346798@qq.com");
        user.setRole("1");
        System.out.println(userController.addUser(user));
        System.out.println(userController.getUsers());
    }

    @Test
    void testModify(){
        Users user = new Users();
        user.setUserID(3L);
        user.setUsername("lisi***");
        userController.updateUser(user);

        System.out.println(userController.getUserById(3L));

    }

}
