package com.example;

import com.example.controller.DeviceController;
import com.example.controller.UserController;
import com.example.dto.UserDTO;
import com.example.entity.Devices;
import com.example.entity.Users;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest
class TrafficApplicationTests {

//    @Autowired
//    private DataRecordsController dataRecordsController;
    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
//        System.out.println(dataRecordsController.getById(1L));
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

    @Test
    void testDelete(){
        System.out.println(userController.deleteUser(3L));
        System.out.println(userController.getUsers());
    }

    @Autowired
    private UserService userService;
    @Test
    void testQuery(){
        System.out.println(userService.query("",""));
        System.out.println("===================================");
        System.out.println(userService.query("admin",""));
    }





    @Autowired
    private DeviceController deviceController;
    @Test
    void testGetDevices(){
        System.out.println(deviceController.getDevices());
    }

    @Test
    void testAddDevice(){
        Devices device = new Devices();
        device.setDeviceName("device1");
        device.setDeviceType("1");
        device.setStatus("1");
        device.setFirmwareVersion("1.0");
        device.setLastMaintenance(LocalDateTime.now());

        System.out.println(deviceController.addDevice(device));
    }

    @Test
    void testModifyDevice(){
        Devices device = new Devices();
        device.setDeviceID(1L);
        device.setDeviceName("device1***");
        deviceController.updateDevice(device);
        System.out.println(deviceController.getDevices());
    }

    @Test
    void testDeleteDevice(){
        System.out.println(deviceController.deleteDevice(1L));
        System.out.println(deviceController.getDevices());
    }

    @Test
    void testQueryDevice(){
        System.out.println(deviceController.query("",""));
        System.out.println("===================================");
        System.out.println(deviceController.query("device1",""));
    }

}
