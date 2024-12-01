package com.example;

import com.example.controller.DataRecordsController;
import com.example.controller.UserController;
import com.example.dto.UserDTO;
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

}
