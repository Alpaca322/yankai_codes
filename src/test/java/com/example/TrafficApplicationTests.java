package com.example;

import com.example.controller.DataRecordsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class TrafficApplicationTests {

    @Autowired
    private DataRecordsController dataRecordsController;

    @Test
    void contextLoads() {
        System.out.println(dataRecordsController.getById(1L));
    }

}
