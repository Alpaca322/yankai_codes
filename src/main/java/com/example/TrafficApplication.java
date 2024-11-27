package com.example;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling   //开启定时任务
@EnableTransactionManagement //开启注解方式的事务管理
@MapperScan("com.example.mapper") //扫描mapper接口
public class TrafficApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrafficApplication.class, args);
    }

}
