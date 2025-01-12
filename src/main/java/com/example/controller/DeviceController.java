package com.example.controller;

import com.example.entity.Devices;
import com.example.service.DeviceService;
import com.example.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/device")
@Api(tags = "设备模块")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping
    @ApiOperation(value = "获取设备列表")
    public Result getDevices(){
        return deviceService.getDevices();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除设备")
    public Result deleteDevice(@PathVariable Long id){
        return deviceService.deleteDevice(id);
    }

    @PutMapping
    @ApiOperation(value = "更新设备")
    public Result updateDevice(@RequestBody Devices device){
        return deviceService.updateDevice(device);
    }

    @PostMapping
    @ApiOperation(value = "添加设备")
    public Result addDevice(@RequestBody Devices device){
        return deviceService.addDevice(device);
    }

    @GetMapping("/query")
    @ApiOperation(value = "查询设备")
    public Result query(@PathParam("deviceName") String deviceName,@PathParam("deviceType") String deviceType){

        return deviceService.query(deviceName,deviceType);
    }



}
