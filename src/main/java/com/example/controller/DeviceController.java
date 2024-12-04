package com.example.controller;

import com.example.entity.Devices;
import com.example.service.DeviceService;
import com.example.utils.Result;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public Result getDevices(){
        return deviceService.getDevices();
    }

    @DeleteMapping("/{id}")
    public Result deleteDevice(@PathVariable Long id){
        return deviceService.deleteDevice(id);
    }

    @PutMapping
    public Result updateDevice(@RequestBody Devices device){
        return deviceService.updateDevice(device);
    }

    @PostMapping
    public Result addDevice(@RequestBody Devices device){
        return deviceService.addDevice(device);
    }

    @GetMapping("/query")
    public Result query(@PathParam("deviceName") String deviceName,@PathParam("deviceType") String deviceType){

        return deviceService.query(deviceName,deviceType);
    }



}
