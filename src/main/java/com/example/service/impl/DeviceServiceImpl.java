package com.example.service.impl;

import com.example.entity.Devices;
import com.example.mapper.DeviceMapper;
import com.example.service.DeviceService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public Result getDevices() {
        List<Devices> devices = deviceMapper.getDevices();
        return Result.success(devices);
    }

    @Override
    public Result updateDevice(Devices device) {
        if (device == null) {
            return Result.error("device不能为空");
        }
        if (device.getDeviceID() == null) {
            return Result.error("id不能为空");
        }
        deviceMapper.updateDevice(device);
        return Result.success();
    }

    @Override
    public Result addDevice(Devices device) {
        deviceMapper.addDevice(device);
        return Result.success();
    }

    @Override
    public Result getDeviceById(Long id) {
        return null;
    }

    @Override
    public Result deleteDevice(Long id) {
        if (id == null) {
            return Result.error("id不能为空");
        }
        deviceMapper.deleteDevice(id);
        return Result.success();
    }

    @Override
    public Result query(String deviceName, String deviceType) {
        Devices device = new Devices();
        device.setDeviceName(deviceName);
        device.setDeviceType(deviceType);
        if (deviceName == null && deviceType == null) {
            this.getDevices();
        }
        List<Devices> devicesList = deviceMapper.query(device);

        return Result.success(devicesList);

    }



}
